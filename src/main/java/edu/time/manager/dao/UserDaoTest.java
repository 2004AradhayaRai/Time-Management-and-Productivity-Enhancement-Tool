package main.java.edu.time.manager.dao;

import main.java.edu.time.manager.models.User;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    private static UserDao userDao;
    private static Connection connection;

    @BeforeAll
    static void setup() throws Exception {
        // Initialize H2 Database
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        ds.setUser("sa");
        ds.setPassword("");

        connection = ds.getConnection();
        Statement statement = connection.createStatement();

        // Create the Users table
        statement.execute("""
                CREATE TABLE Users (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    username VARCHAR(50) NOT NULL,
                    email VARCHAR(50) NOT NULL,
                    password_hash VARCHAR(100) NOT NULL,
                    role VARCHAR(20) NOT NULL
                )
            """);

        userDao = new UserDao();
    }

    @Test
    void testCreateUser() {
        User user = new User("testuser", "test@example.com", "hashedpassword", "USER");
        userDao.createUser(user);

        User fetchedUser = userDao.getUserById(1);
        assertNotNull(fetchedUser);
        assertEquals("testuser", fetchedUser.getUsername());
        assertEquals("test@example.com", fetchedUser.getEmail());
    }

    @AfterAll
    static void teardown() throws Exception {
        connection.close();
    }
}
