import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BugTest {
    @BeforeClass
    public static void onetimesetup() {
        
    }

    @Test
    public void testgettester() {
        User user = new User("trent", "waterman", "email@email.com", "12345");
        Bug bug = new Bug("name", "description", 1, "bugs", user);
        assertEquals(bug.getTester(), user);
    }

    @Test
    public void getnulltester() {
        Bug bug = new Bug("name", "description", 1, "bugs", null);
        assertNull(bug.getTester());
    }

    @Test
    public void testStuff(){
        assertTrue(true);
    }

    @Test
    public void testgettitle() {
        User user = new User("trent", "waterman", "email@email.com", "12345");
        Bug bug = new Bug("name", "description", 1, "bugs", user);
        assertEquals(bug.getBug(), "bugs");
    }

    @Test
    public void getnulltitle() {
        User user = new User("trent", "waterman", "email@email.com", "12345");
        Bug bug = new Bug("name", "description", 1, null, user);
        assertNull(bug.getBug());
    }

    @Test
    public void testedittester() {
        User user = new User("trent", "waterman", "email@email.com", "12345");
        User user2 = new User("firts", "last", "email", "12345");
        Bug bug = new Bug("name", "description", 1, "bugs", user);
        bug.editTester(user2);
        assertEquals(bug.getTester(), user2);
    }

    @Test public void testedittestertonull() {
        User user = new User("trent", "waterman", "email@email.com", "12345");
        Bug bug = new Bug("name", "description", 1, "bugs", user);
        User user2 = null;
        bug.editTester(user2);
        assertNull(bug.getTester());
    }

    @Test public void addSubtaskToNullSubtaskList() {
        User user = new User("trent", "waterman", "email@email.com", "12345");
        Bug bug = new Bug("name", "description", 1, "bugs", user);
        bug.addSubTask("subtask");
        //assertNotNull(bug.getSubtasks());
    }

    @Test public void addUserToNullUserList() {
        User user = new User("trent", "waterman", "email@email.com", "12345");
        Bug bug = new Bug("name", "description", 1, "bugs", user);
        bug.addUser(null);
        //assertNotNull(bug.getSubtasks());
    }
    
}
