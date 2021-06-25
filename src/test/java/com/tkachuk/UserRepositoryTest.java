package com.tkachuk;

import com.tkachuk.entities.UserEntity;
import com.tkachuk.repository.UserRepository;
import com.tkachuk.repository.implementations.UserRepositoryImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


public class UserRepositoryTest {

    private static UserRepository userRepository;
    private static UserEntity user1;
    private static UserEntity user2;

    @BeforeClass
    public static void setUp() {
        userRepository = mock(UserRepositoryImpl.class);
        user1 = new UserEntity();
        user1.setUser_id(1);
        user1.setSurname("Surname");
        user1.setPassword("password");
        user1.setLogin("login");

        user2 = new UserEntity();
        user2.setUser_id(2);
        user2.setSurname("Surname2");
        user2.setLogin("mylogin");
        when(userRepository.findByLogin("mylogin")).thenReturn(user2);
        when(userRepository.findByLoginAndPassword("login", "password")).thenReturn(user1);
    }

    @Test
    public void testFindByLogin(){
        UserEntity user = userRepository.findByLogin(user2.getLogin());
        assertNotNull(user);
        assertEquals(new Integer(2), user.getUser_id());
    }

    @Test
    public void testFindByLoginAndPassword(){
        UserEntity user = userRepository.findByLoginAndPassword(user1.getLogin(), user1.getPassword());
        assertNotNull(user);
        assertEquals("Surname", user.getSurname());
    }

}
