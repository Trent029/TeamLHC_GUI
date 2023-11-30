import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * @author Shruti
 */
class DataWriterTest {
	private UserList users = UserList.getInstance();
	private ArrayList<User> userList = users.getUsers();

    private TaskList tasks = TaskList.getInstance();
    private ArrayList<Task> taskList = tasks.getTasks();

    private ProjectBoard projects = ProjectBoard.getInstance();
    private ArrayList<Project> projectList = projects.getAllProjects();
	
	@BeforeEach
	public void setup() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers();

        TaskList.getInstance().getTasks().clear();
        DataWriter.saveTasks();
        
        ProjectBoard.getInstance().getAllProjects().clear();
        DataWriter.saveProjects();
	}
	
	@AfterEach
	public void tearDown() {
		UserList.getInstance().getUsers().clear();
		DataWriter.saveUsers();

        TaskList.getInstance().getTasks().clear();
        DataWriter.saveTasks();
        
        ProjectBoard.getInstance().getAllProjects().clear();
        DataWriter.saveProjects();
	}
	
	
	@Test
	void testWritingZeroUsers() {
		userList = DataLoader.getUsers();
		assertEquals(0, userList.size());
	}

	@Test
	void testWritingOneUser() {
		userList.add(new User("amy","smith","a1@email.com","a1"));
		DataWriter.saveUsers();
		assertEquals("a1@email.com", DataLoader.getUsers().get(0).getEmailID());
	}
	
	@Test
	void testWritingFiveUsers() {
		userList.add(new User("amy","smith","a1@email.com","a1"));
		userList.add(new User("amy2","smith","a2@email.com","a2"));
		userList.add(new User("amy3","smith","a3@email.com","a3"));
		userList.add(new User("amy4","smith","a4@email.com","a4"));
		userList.add(new User("amy5","smith","a5@email.com","a5"));
		
        
        DataWriter.saveUsers();
		assertEquals("a5@email.com", DataLoader.getUsers().get(4).getEmailID());
	}
	
    @Test
    void testWritingEmptyUser()
    {
        userList.add(new User("","","",""));
        DataWriter.saveUsers();
        assertEquals("",DataLoader.getUsers().get(0).getEmailID());
    }

    @Test
    void testWritingNullUser()
    {
        userList.add(new User(null,null,null,null));
        DataWriter.saveUsers();
        assertEquals(null, DataLoader.getUsers().get(0).getEmailID());
    }
	
	@Test
	void testWritingZeroTasks()
	{
		taskList = DataLoader.getTasks();
		assertEquals(0,taskList.size());
	}

	@Test
	void testWritingTwoTasks()
	{
		taskList.add(new Bug("Its a bug","",1,"bugbug",new User("amy","smith","a1@email.com","1234")));
		taskList.add(new Feature("its a feature", "", 1, "featurefeat"));
		DataWriter.saveTasks();
		assertEquals("Its a bug", DataLoader.getTasks().get(0).getTaskName());

	}

	@Test
	void testWritingEmptyTasks()
	{
		taskList.add(new Feature("","",1,""));
		DataWriter.saveTasks();
		assertEquals("",DataLoader.getTasks().get(0).getTaskName());
	}

	@Test
	void testWritingNullTasks()
	{
		taskList.add(new Feature(null,null,1,null));
		DataWriter.saveTasks();
		assertNull(DataLoader.getTasks().get(0).getTaskName());
	}

	@Test
	void testWritingZeroProjects()
	{
		projectList = DataLoader.getProjects();
		assertEquals(0,projectList.size());
	}
	
	@Test
	void testWritingTwoProjects()
	{
		projectList.add(new Project("proj1", "dec1"));
		projectList.add(new Project("proj2","desc2"));
		DataWriter.saveProjects();
		assertEquals("desc2", DataLoader.getProjects().get(1).getProjectDescription());
	}

	@Test
	void testWritingNullProject()
	{
		projectList.add(new Project(null,null));
		DataWriter.saveProjects();
		assertNull(DataLoader.getProjects().get(0).getProjectName());
	}

	@Test
	void testWritingEmptyProject()
	{
		projectList.add(new Project("", ""));
		DataWriter.saveProjects();
		assertEquals("",DataLoader.getProjects().get(0).getProjectName());
	}


}