package com.tkachuk.repository.implementations;

import com.tkachuk.entities.UserEntity;
import com.tkachuk.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(UserEntity user) {
        entityManager.persist(user);
    }

    @Override
    public UserEntity findByLoginAndPassword(String login, String password) {
        try {
            return (UserEntity) entityManager.createQuery("from UserEntity where login = :login and password = :password")
                    .setParameter("login", login).setParameter("password", password).getSingleResult();
        } catch (NoResultException e) {
        }
        return null;
    }

    @Override
    public UserEntity findByLogin(String login) {
        try {
            return (UserEntity) entityManager.createQuery("from UserEntity where login = :login").setParameter("login", login)
                    .getSingleResult();
        } catch (NoResultException e) {
        }
        return null;
    }
}
