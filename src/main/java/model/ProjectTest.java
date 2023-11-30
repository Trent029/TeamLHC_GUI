/**
 * @author Sri Nandury
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProjectTest {
    private UserList users = UserList.getInstance();
    private ArrayList<User> userList = users.getUsers();
    private ProjectBoard projects = ProjectBoard.getInstance();
    private ArrayList<Project> projectList = projects.getAllProjects();

    @BeforeEach
    public void setup(){
        User user = new User("Suzy", "william", "suzywilly@gmail.com", "newme123");
        userList.add(user);
        Project project = new Project("Moviess", "watchlist of movies");
        projects.addProject(project);
    }

    @Test
    public void testProjectNameWithSpaces(){
        Project proj1 = new Project("      ", "idk");
        projects.addProject(proj1);
        assertEquals("      ", proj1.getProjectName());
    }

    @Test
    public void testProjectDescriotionWithSpaces(){
        Project proj1 = new Project("newer", "      ");
        projects.addProject(proj1);
        assertEquals("      ", proj1.getProjectDescription());    
    }

} 
