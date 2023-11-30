package model;
import java.util.ArrayList;
import java.util.UUID;

/**
 * A list of tasks
 * @author Shruti
 */

public class TaskList {
    private ArrayList<Task> tasks;
    private static TaskList taskList;

    /**
     * Creates a list of tasks
     */
    public TaskList() 
    {
        this.tasks= DataLoader.getTasks();
    }

    /**
     * Get instance of a task list
     * @return A list of tasks, whether new or existing
     */
    public static TaskList getInstance() {
        if(taskList == null)
        {
            taskList = new TaskList();
        }
        return taskList;
    }

    /**
     * Get a task from the list by its name
     * @param taskName The name of the task
     * @return The task with its name (if it exists)
     */
    public Task getTask(String taskName)
    {
        for(int i=0;i<tasks.size();i++)
        {
            if(tasks.get(i).getTaskName().equalsIgnoreCase(taskName))
            {
                return tasks.get(i);
            }
        }
        return null;
    }

    /**
     * Get a task by its uuid
     * @param taskID The uuid of a task
     * @return The task with the uuid (if it exists)
     */
    public Task getTask(UUID taskID)
    {
        tasks = DataLoader.getTasks();
        for(int i=0; i<tasks.size(); i++)
        {
            if(tasks.get(i).getTaskId().equals(taskID))
                return tasks.get(i);
        }
        return null;
    }

    /**
     * Get all tasks from the list
     * @return An array list of all tasks
     */
    public ArrayList<Task> getTasks()
    {
        return this.tasks;
    }

     //testing-
     public boolean addTask(String taskName) //only checking if we can add user based on emailID!!
    {
        //loop through userlist-check for unqiue email
        //true if email is not found
        tasks = DataLoader.getTasks();
        for(int i=0;i<tasks.size();i++)
        {
            if(tasks.get(i).taskName.equalsIgnoreCase(taskName))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Add a task to the list
     * @param taskName The name of the task
     * @param description Information about the task
     * @param priority The level of importance of the task
     * @param title The description for the bug/feature
     * @param tester The person adding the task
     * @return True always, and adds a task to the array list, whether or not tester is null
     */
    public boolean add(String taskName, String description, int priority, String title, User tester) {
        if (tester != null) {
           Bug task = new Bug(taskName, description, priority, title, tester);
           tasks.add(task);
        } else {
           Feature task = new Feature(taskName, description, priority, title);
           tasks.add(task);
        }
        return true;
     }

    /**
     * Adds a task
     * @param task An objective for a project
     */
     public void add(Task task) {
        tasks.add(task);
    } 

    /**
     * Saves the tasks in the data writer
     */
    public void saveTasks()
    {
        DataWriter.saveTasks();
    }

}
