package model;
//import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Sri Nandury
 */

public abstract class Task {

    public UUID taskID;
    public ArrayList<User> users;
    public String taskName;
    public String taskDescription;
    public int taskPriority;
    public ArrayList<Comment> taskComments;
    public ArrayList<String> subTasks;
    
    /**
     * Loads an existing class
     * @param taskUUID The uuid of the task
     * @param users An array list of all current users
     * @param taskName The name of the task
     * @param taskDescription Information about the task
     * @param taskPriority The level of importance of the task
     * @param taskComments Comments from the task
     * @param subtasks Smaller tasks within the main task
     */
    public Task(UUID taskUUID,ArrayList<User> users,String taskName, String taskDescription, int taskPriority, ArrayList<Comment> taskComments,ArrayList<String> subtasks)
    {
        this.taskID = taskUUID; 
        this.users = users;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskPriority = taskPriority;
        this.taskComments = taskComments;
        this.subTasks = subtasks;
    }

    /**
     * Creates a new class
     * @param taskName The name of the task
     * @param taskDescription Information about the task
     * @param taskPriority The level of importance of the task
     */
    public Task(String taskName, String taskDescription, int taskPriority){
        this.taskID = UUID.randomUUID(); 
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskPriority = taskPriority;
        this.taskComments = null;
        this.subTasks = null;
        this.users = null;
    }

    /**
     * Sets/Changes task name
     * @param taskName The name of the task
     */
    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    /**
     * Sets/Changes task description
     * @param taskDescription Information about the task
     */
    public void setTaskDescription(String taskDescription){
        this.taskDescription = taskDescription;
    }

    /**
     * Sets/Changes task priority
     * @param taskPriority The level of importance of the task
     */
    public void setPriority(int taskPriority){
        this.taskPriority = taskPriority;
    }

    /**
     * adds comments to ArrayList of comments
     * @param comment A comment from the task
     */
    public void addComment(Comment comment)
    {
        if(taskComments==null)
        {
            taskComments= new ArrayList<Comment>();
            taskComments.add(comment);
        }
        else
        {
            taskComments.add(comment);
        }

    }

    /**
     * Adds subTask to the array list of subtask for a task
     * @param subTask Smaller tasks within the main task
     */
    public void addSubTask(String subTask)
    {
        subTasks.add(subTask);
    }

    /**
     * Adds user to a task with their uuid
     * @param user The ID for a user
     */
    public void addUser(User user)
    {
        if(users==null)
        {
            this.users = new ArrayList<User>();
            users.add(user);
        }
        else
        {
            users.add(user);
        }
        
    }
    //testing
    /**
     * Returns a string of the task's attributes
     */
    public String toString()
    {
        return "\n  TASKNAME: " + this.taskName+ "\n     DESCRIPTION: "+this.taskDescription+"\n     USERS:"+this.users+"\n     PRIORITY:"+this.taskPriority+"\n     SUBTASKS: "+this.subTasks+"\n     COMMENTS"+this.taskComments;
    }

    /**
     * Returns the task ID
     * @return The uuid of a task
     */
    public UUID getTaskId()
    {
        return this.taskID;
    }
    /**
     * Returns the task name
     * @return The name of a task
     */
    public String getTaskName()
    {
        return this.taskName;
    }
    /**
     * Return the task description
     * @return The description of a task
     */
    public String getTaskDescription()
    {
        return this.taskDescription;
    }
    /**
     * Return the task priority
     * @return The importance number of a task
     */
    public int getTaskPriority()
    {
        return this.taskPriority;
    }
    /**
     * Returns all users in the array list
     * @return The array list of all users
     */
    public ArrayList<User> getUsers()
    {
        return this.users;
    }
    /**
     * Returns all comments in a task
     * @return The array list of all comments
     */
    public ArrayList<Comment> getTaskComments()
    {
        return this.taskComments;
    }
    /**
     * Returns all subtasks in a task
     * @return The array list of all subtasks
     */
    public ArrayList<String> getSubtasks()
    {
        return this.subTasks;
    }
    
    public void changeUser(User addUser, User removeUser)
    {
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).equals(removeUser))
            {
                users.remove(i);
            }
        }
        users.add(addUser);
    }

}
