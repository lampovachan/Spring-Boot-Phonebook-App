package com.tkachuk.repository;

import com.tkachuk.entities.ContactsEntity;
import com.tkachuk.entities.UserEntity;

import java.util.List;

public interface ContactsRepository {
    List<ContactsEntity> getUserContacts(UserEntity user);

    ContactsEntity findContactById(Integer contactId);

    void createContact(ContactsEntity contact);

    void deleteContact(ContactsEntity contact);

    void editContact(ContactsEntity contact);
}
