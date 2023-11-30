import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * @author Shruti
 */

public class DataLoaderTest {
    private UserList users = UserList.getInstance();
    private ArrayList<User> userList = users.getUsers();

    private TaskList tasks = TaskList.getInstance();
    private ArrayList<Task> taskList = tasks.getTasks();

    private ProjectBoard projects = ProjectBoard.getInstance();
    private ArrayList<Project> projectList = projects.getAllProjects();
	
	@BeforeEach
	public void setup() {
        //runs before each test
        userList.clear();
        User amy1 = new User("amy", "smith", "a@email.com", "1234");
        User amy2 = new User("amy2","smith2","a2@email.com","1212");
        userList.add(amy1);
        userList.add(amy2);
        userList.add(new User(null,null,null,null));
        DataWriter.saveUsers();

        taskList.clear();
        taskList.add(new Bug("bug","",1,"fix something",amy2));
        taskList.add(new Feature("feat","",1,"add something"));
        taskList.get(0).addUser(amy2);
        taskList.get(1).addUser(amy1);
        DataWriter.saveTasks();

        projectList.clear();
        projectList.add(new Project("proj1", null));
        projectList.add(new Project("proj2",""));
        DataWriter.saveProjects();
	}
	
	@AfterEach
	public void tearDown() {
		//runs after each test
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();

        TaskList.getInstance().getTasks().clear();
        DataWriter.saveTasks();

        ProjectBoard.getInstance().getAllProjects().clear();
        DataWriter.saveProjects();
	}

    @Test
    void testGetUsersSize()
    {
        userList = DataLoader.getUsers();
        assertEquals(3,userList.size());
    }

    @Test
    void testGetUsersSizeZero()
    {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        assertEquals(0,userList.size());
    }

    @Test
    void testGetUserFirstUserEmail()
    {
        userList = DataLoader.getUsers();
        assertEquals("a@email.com",userList.get(0).getEmailID());
    }

    @Test
    void testNullUser()
    {
        userList = DataLoader.getUsers();
        assertEquals(null,userList.get(2).getFirstName());
    }

    @Test
    void testNullUserUUID()
    {
        userList = DataLoader.getUsers();
        assertEquals(null,userList.get(0).getId());
    }

    @Test
    void testGetTasksSize()
    {
        taskList = DataLoader.getTasks();
        assertEquals(2,taskList.size());
    }

    @Test
    void testGetTasksSizeZero()
    {
        TaskList.getInstance().getTasks().clear();
        DataWriter.saveTasks();
        assertEquals(0,taskList.size());
    }

    @Test
    void testGetUserOnTask()
    {
        taskList = DataLoader.getTasks();
        assertNotNull(taskList.get(0).getUsers());

    }

    @Test
    void testGetProjectsSize()
    {
        projectList = DataLoader.getProjects();
        assertEquals(3,projectList.size());
    }

    @Test
    void testGetProjectsSizeZero()
    {
        ProjectBoard.getInstance().getAllProjects().clear();
        DataWriter.saveProjects();
        assertEquals(0,projectList.size());
    }

    @Test
    void testGetTasksInProject()
    {
        projectList = DataLoader.getProjects();
        assertNull(projectList.get(0).getTask());
    }


    
}
