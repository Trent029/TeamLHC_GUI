package model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Array list of tasks
 * @author Sri Nandury
 */

public class Column {

  public String name;
  private ArrayList<Task> tasks;

  /**
   * Initializes a column
   * @param name The name of the column
   * @param tasks All tasks for a column
   */
  public Column(String name, ArrayList<Task> tasks) 
  {
    this.name = name;
    this.tasks = tasks;
  }

  public Column(String name) {
   this.name = name;
   this.tasks = new ArrayList<Task>();
  }

  /**
   * Adds a task to a column
   * @param task The specified task for a column
   */
  public void addtask(Task task)
  {
   if(this.tasks==null)
   {
      this.tasks = new ArrayList<Task>();
      tasks.add(task);
   }
   else
   {
      tasks.add(task);
   }
    
  }

  /**
   * Removes a task from a column
   * @param task The specified task for a column
   */
  public void deleteTask(Task task)
  {
    tasks.remove(task);
  }

  /**
   * Call an existing task
   * @param taskName The name of the task
   * @param description Information about the task
   * @param priority The level of importance of the task
   * @param title The description for the bug/feature
   * @param tester The person creating the task
   */
  public void createTask(String taskName, String description, int priority, String title, User tester) {
     if (tester != null) {
        Bug task = new Bug(taskName, description, priority, title, tester);
        tasks.add(task);
     } else {
        Feature task = new Feature(taskName, description, priority, title);
        tasks.add(task);
     }
  }

  /**
   * Create a new task
   * @param taskUUID The uuid of the task
   * @param users An array list of all current users
   * @param taskName The name of the task
   * @param taskDescription Information about the task
   * @param taskPriority The level of importance of the task
   * @param taskComments Comments from the task
   * @param subtasks Smaller tasks within the main task
   * @param title The description for the bug/feature
   * @param tester The person creating the task
   */
  public void createTask(UUID taskUUID, ArrayList<User> users, String taskName, String taskDescription, int taskPriority, ArrayList<Comment> taskComments, ArrayList<String> subtasks, String title, User tester) {
     if (tester != null) {
        Bug task = new Bug(taskUUID, users, taskName, taskDescription, taskPriority, taskComments, subtasks, title, tester);
        tasks.add(task);
     } else {
        Feature task = new Feature(taskUUID, users, taskName, taskDescription, taskPriority, taskComments, subtasks, title);
        tasks.add(task);
     }
  }

  /**
   * Return column name
   * @return The name of the column
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns all tasks
   * @return The array list of tasks
   */
  public ArrayList<Task> getTasks() {
   return this.tasks;
  }

  /**
   * Changes name of column
   * @param name The name of the column
   */
  public void changeName(String name) {
   this.name = name;
  }

  /*
   * Calls a task by name
   */
  public Task getTask(String name) {
   for (int i=0; i<tasks.size(); i++) {
      if (name == tasks.get(i).getTaskName()){
         return tasks.get(i);
      }
   }
   return null;
  }

  /**
   * Calls a task by ID
   * @param taskid The ID for a task
   * @return The requested task by ID
   */
  public Task getTask(UUID taskid) {
   for (int i=0; i<tasks.size(); i++) {
      if (taskid == tasks.get(i).getTaskId()) {
         return tasks.get(i);
      }
   }
   return null; 
   }
   
   /**
    * Prints the selected column and task
    @return A string representation of the column and task
    */
   public String toString()
   {
      return "\n"+this.name.toUpperCase()+"\n "+this.tasks;
   }
}