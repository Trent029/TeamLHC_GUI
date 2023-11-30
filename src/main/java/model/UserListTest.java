import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class UserListTest {
    @Test
    public void testConstructor() {
        UserList userList = new UserList();
        userList.getInstance().add("Yug", "Desai", "email@email.com", "12345");
        assertEquals(userList.getInstance().getUserbyName("Yug","Desai").getFirstName(), "Yug");
        assertEquals(userList.getInstance().getUserbyName("Yug","Desai").getLastName(), "Desai");
        assertEquals(userList.getInstance().getUserbyName("Yug","Desai").getEmailID(), "email@email.com");
        assertEquals(userList.getInstance().getUserbyName("Yug","Desai").getPassword(), "12345");//fixe48d 
    }
}
