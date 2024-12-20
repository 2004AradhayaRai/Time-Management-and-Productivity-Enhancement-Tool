package main.java.edu.time.manager.services;

import main.java.edu.time.manager.dao.UserDao;
import main.java.edu.time.manager.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserService userService;
    private UserDao mockUserDao;

    @BeforeEach
    void setup() {
        mockUserDao = mock(UserDao.class);
        userService = new UserService(mockUserDao);
    }

    @Test
    void testRegisterUser() {
        User user = new User("newuser", "newuser@example.com", "hashedpassword", "USER");

        userService.registerUser(user);

        verify(mockUserDao, times(1)).createUser(user);
    }

    @Test
    void testGetUserById() {
        User user = new User(1, "mockuser", "mock@example.com", "hashedpassword", "USER");
        when(mockUserDao.getUserById(1)).thenReturn(user);

        User fetchedUser = userService.getUserById(1);

        assertNotNull(fetchedUser);
        assertEquals("mockuser", fetchedUser.getUsername());
        assertEquals("mock@example.com", fetchedUser.getEmail());
    }
}
