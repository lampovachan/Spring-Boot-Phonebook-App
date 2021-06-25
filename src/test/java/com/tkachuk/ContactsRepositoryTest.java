package com.tkachuk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.tkachuk.entities.ContactsEntity;
import com.tkachuk.entities.UserEntity;
import com.tkachuk.repository.ContactsRepository;
import com.tkachuk.repository.implementations.ContactsRepositoryImpl;
import org.junit.BeforeClass;
import org.junit.Test;

public class ContactsRepositoryTest {

    private static ContactsRepository contactsRepository;
    private static ContactsEntity contacts1;
    private static ContactsEntity contacts2;
    private static UserEntity user1;
    @BeforeClass
    public static void setUp(){
        user1 = new UserEntity();

        contactsRepository = mock(ContactsRepositoryImpl.class);
        contacts1 = new ContactsEntity();
        contacts1.setName("Name");
        contacts1.setMobilephone("2345");
        contacts1.setUserId(user1);

        contacts2 = new ContactsEntity();
        contacts2.setName("Name2");
        contacts2.setMobilephone("123");
        contacts2.setContact_id(1);
        when(contactsRepository.getUserContacts(user1)).thenReturn(Arrays.asList(contacts1));
        when(contactsRepository.findContactById(1)).thenReturn(contacts2);
    }

    @Test
    public void testGetUsersContacts(){
        List<ContactsEntity> contacts = contactsRepository.getUserContacts(user1);
        assertEquals(1, contacts.size());
        assertEquals("Name", contacts.get(0).getName());
    }

    @Test
    public void testFindContactById(){
        ContactsEntity contact = contactsRepository.findContactById(contacts2.getContact_id());
        assertNotNull(contact);
        assertEquals("123", contact.getMobilephone());
    }
}