package model;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Section for projects
 * @author Yug Desai
 */
public class ProjectBoard {
    public ArrayList<Project> projects;
    public static ProjectBoard projectBoard;
    
    /**
     * Places the projects onto the project board
     */
    public ProjectBoard()
    {
        projects = DataLoader.getProjects();
    }

    /**
     * Gets an instance of the project board
     * @return A new or existing project board
     */
    public static ProjectBoard getInstance() {
        
        if(projectBoard==null)
        {
            projectBoard = new ProjectBoard();
        }
        return projectBoard;
    }

    /**
     * Calls an existing project
     * @param projectName The name of the project
     * @param projectDescription The name of the project's description
     */
    public void createProject(String projectName,String projectDescription)
    {
        Project project = new Project(projectName,projectDescription);
        projects.add(project);
    }

    /**
     * Makes a new project
     * @param projectID The uuid of the project
     * @param projectName The name of the project
     * @param projectDescription The name of the project's description
     * @param columns An array list of all columns
     * @param comment An array list of all comments
     * @param users An array list of all users
     * @param scrumMaster The SCRUM master of the project
     * @param productOwner The product owner of the project
     */
    public void createProject(UUID projectID, String projectName, String projectDescription, ArrayList<Column> columns, ArrayList<Comment> comment, ArrayList<User> users, User scrumMaster, User productOwner) {
        Project project = new Project(projectID, projectName, projectDescription, columns, comment, users, scrumMaster, productOwner);
        projects.add(project);
    }
    
    public void addProject(Project project) {
        projects.add(project);
    }

    /**
     * Get a project by its uuid
     * @param uuid The ID of the project
     * @return The selected project (if the uuid exists)
     */
    public Project getProject(UUID uuid) {
        for (int i=0; i<projects.size(); i++) {
            if (projects.get(i).getProjectID() == uuid) {
                return projects.get(i);
            }
        }
        return null;
    }

    /**
     * Get a project by its name
     * @param name The name of a project
     * @return The selected project (if the name exists)
     */
    public Project getProject(String name) {
        for (int i=0; i<projects.size(); i++) {
            if (projects.get(i).getProjectName().equalsIgnoreCase(name)) {
                return projects.get(i);
            }
        }
        return null;
    }

    /**
     * Gets all current projects
     * @return An array list of all projects
     */
    public ArrayList<Project> getAllProjects()
    {
        return projects;
    }

    /**
     * Get a project by users
     * @param userEmail The email of a user
     * @return The selected project
     */
    public ArrayList<Project> getProjectByUser(String userEmail) {
        ArrayList<Project> userProjects = new ArrayList<Project>();
        for (int i=0; i<projects.size(); i++) 
        {
            for(int j=0;j<projects.get(i).getUsers().size();j++)
            {
                if(projects.get(i).getUsers().get(i).userEmail.equals(userEmail))
                {
                    userProjects.add(projects.get(i));
                }
            }
        }
        return userProjects;
    }

}
