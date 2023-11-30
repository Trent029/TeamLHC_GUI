package model;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class UserTest {

    @Test
    public void testConstructor() {
        User user = new User("Yug", "Desai", "email@email.com", "12345");
        assertEquals(user.getFirstName(), "Yug");
        assertEquals(user.getLastName(), "Desai");
        assertEquals(user.getEmailID(), "email@email.com");
        assertEquals(user.getPassword(), "12345");
    }
}
