package model;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Programming project for a group
 * @author Yug Desai 
 */
public class Project {
    private String projectName;
    private UUID projectID;
    private String projectDescription;
    private ArrayList<Column> columns;
    private ArrayList<Comment> comments;
    private ArrayList<User> users;
    private User scrumMaster;
    private User productOwner;
    
    /**
     * Calls an existing project
     * @param projectID The uuid of the project
     * @param projectName The name of the project
     * @param projectDescription The name of the description
     * @param columns An array list of all project columns
     * @param comment An array list of all project comments
     * @param users An array list of all current users
     * @param scrumMaster The user who manages the SCRUM
     * @param productOwner The user who owns the product
     */
    public Project(UUID projectID, String projectName, String projectDescription, ArrayList<Column> columns, ArrayList<Comment> comment, ArrayList<User> users, User scrumMaster, User productOwner) {
        this.projectName = projectName;
        this.projectID = projectID;
        this.projectDescription = projectDescription;
        this.users = users;
        this.columns = columns;
        this.scrumMaster = scrumMaster;
        this.productOwner = productOwner;
        this.comments = comment;
    }

    /**
     * Makes a new project
     * @param projectName The name of the project
     * @param projectDescription The name of the description
     */
    public Project(String projectName, String projectDescription)
    {
        this.projectID = UUID.randomUUID();
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.users = null;
        this.columns=null;
        this.comments=null;
        this.scrumMaster = null;
        this.productOwner = null;
    }

    /**
     * Adds a column in the project
     * @param column The section for a list of tasks
     */
    public void addColumn(Column column) {
        columns.add(column);
    }

    /**
     * Removes a column from the project
     * @param column The section for a list of tasks
     */
    public void deleteColumn(Column column) {
        columns.remove(column);
    }

    /**
     * Marks a task as completed
     * @param task An objective for a project
     * @return A completed task as true
     */
    public boolean completedTask(Task task) {
        return true;

    }

    /**
     * Adds a comment to an array list of comments
     * @param comment A comment made by a user
     */
    public void addTask(Task task)
    {
        for(int i=0;i<columns.size();i++)
        {
            if(columns.get(i).name.equalsIgnoreCase("todo"))
            {
                columns.get(i).addtask(task);
                TaskList.getInstance().add(task);
            }
        }
    }

    /**
     * Moves a task around a column
     * @param task An objective for a project
     * @param column The section for a list of tasks
     */
    public void moveTask(Task task, String columnName)
    {
        for(int i=0; i<columns.size();i++) {
            if(columns.get(i).getTask(task.getTaskName()) != null) {
                columns.get(i).deleteTask(task);
            }
        }
        getColumn(columnName).addtask(task);
    }


    public Column getColumn(String columnName)
    {
        for(int i=0;i<columns.size();i++)
        {
            if(columns.get(i).name.equalsIgnoreCase(columnName))
            {
                return columns.get(i);
            }
        }
        return null;
    }

    public Task getTask(String taskName)
    {
        for(int i=0;i<columns.size();i++)
        {
            for(int j=0;j<columns.get(i).getTasks().size();j++)
            {
                if(columns.get(i).getTasks().get(j).taskName.equalsIgnoreCase(taskName))
                {
                    return columns.get(i).getTasks().get(j);
                }
            }
        }
        return null;
    }

    /**
     * Adds a comment to an array list of comments
     * @param comment A comment made by a user
     */
    public void addComment(Comment comment) 
    {
        comments.add(comment);
    }

    /**
     * Adds a user to an array list of users
     * @param user The person who is part of the making of a project
     */
    public void addUsers(User user) 
    {
       users.add(user);
    }

    /**
     * Returns the name of a project
     * @return The project's name
     */
    public String getProjectName() {
        return this.projectName;
    }

    /**
     * Returns the uuid of a project
     * @return The project's uuid
     */
    public UUID getProjectID() {
        return this.projectID;
    }

    /**
     * Returns information about the project
     * @return The project's description
     */
    public String getProjectDescription() {
        return this.projectDescription;
    }

    /**
     * Get all current users
     * @return An array list of users
     */
    public ArrayList<User> getUsers() {
        return this.users;
    }

    /**
     * Get all current columns
     * @return An array list of columns
     */
    public ArrayList<Column> getColumns() {
        return this.columns;
    }

    /**
     * Get all current comments
     * @return An array list of comments
     */
    public ArrayList<Comment> getComments() {
        return this.comments;
    }

    /**
     * Get a specified task
     * @return The chosen task
     */
    public Task getTask()
    {
        //cycle through all tasks in project and return task
        return null;
    }

    /**
     * Display the SCRUM master of the project
     * @return The project scrum master
     */
    public User getScrumMaster() {
        return scrumMaster;
    }

    /**
     * Display the product owner of the project
     * @return The project's product owner
     */
    public User getProductOwner() {
        return productOwner;
    }

    /**
     * Shows all the info for a project
     * @return The Project's ID, name, and description, the columns, comments, SCRUM master, product owner, and all users
     */
    public String toString()
    {
        return "\n\nPROJECT\nNAME: "+this.projectName+"\nDESCRIPTION: "+this.projectDescription+"\nSCRUMMASTER: "+this.scrumMaster+"\nPRODUCTOWNER: "+this.productOwner+"\nUSERS: "+this.users+"\nCOLUMNS:\n"+this.columns+"\nPROJECT-COMMENTS"+this.comments+"\n";
    }
    /**
     * Sets the SCRUM master for the project
     * @param user The person who is part of the making of a project
     */
    public void setScrumMaster(User user)
    {
        this.scrumMaster = user;
    }
    /**
     * Sets the product owner for the project
     * @param user The person who is part of the making of a project
     */
    public void setProductOwner(User user)
    {
        this.productOwner = user;
    }


}