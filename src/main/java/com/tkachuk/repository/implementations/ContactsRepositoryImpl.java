package com.tkachuk.repository.implementations;

import com.tkachuk.entities.ContactsEntity;
import com.tkachuk.entities.UserEntity;
import com.tkachuk.repository.ContactsRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ContactsRepositoryImpl implements ContactsRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List getUserContacts(UserEntity user) {
        try {
            return entityManager.createQuery("from ContactsEntity where userId = :userId").setParameter("userId", user)
                    .getResultList();
        } catch (NoResultException e) {
        }
        return null;
    }

    @Override
    public ContactsEntity findContactById(Integer contactId) {
        try {
            return (ContactsEntity) entityManager.createQuery("from ContactsEntity where contactId =:contactId")
                    .setParameter("contactId", contactId).getSingleResult();
        } catch (NoResultException e) {
        }
        return null;
    }

    @Override
    public void createContact(ContactsEntity contact) {
        entityManager.persist(contact);
    }


    @Override
    public void deleteContact(ContactsEntity contact) {
        if(entityManager.contains(contact)) {
            entityManager.remove(contact);
        }
    }

    @Override
    public void editContact(ContactsEntity contact) {
        entityManager.merge(contact);
    }
}
