package com.tkachuk.service.implementations;

import com.tkachuk.entities.ContactsEntity;
import com.tkachuk.entities.UserEntity;
import com.tkachuk.repository.ContactsRepository;
import com.tkachuk.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {
    @Autowired
    ContactsRepository contactsRepository;

    @Override
    public List<ContactsEntity> getUserContacts(UserEntity user) {
        if (user!=null) {
            return contactsRepository.getUserContacts(user);
        }
        return null;
    }

    @Override
    public ContactsEntity findContactById(Integer contactId) {
        if (contactId!=0) {
            return contactsRepository.findContactById(contactId);
        }
        return null;
    }

    @Override
    public void createContact(ContactsEntity contact) {
        if (contact!=null) {
            contactsRepository.createContact(contact);
        }
    }

    @Override
    public void deleteContact(ContactsEntity contact) {
        if (contact!=null) {
            contactsRepository.deleteContact(contact);
        }
    }

    @Override
    public void editContact(ContactsEntity contact) {
        if (contact!=null) {
            contactsRepository.editContact(contact);
        }
    }
}
