package model;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProjectFACADE {
    private User user;
    private ProjectBoard projectBoard;
    private Task task;
    private Project project;

    public User login(String emailID, String password) {
        user = UserList.getInstance().getUser(emailID,password);
        return user;
    }

    public Boolean signUp(String firstName, String LastName, String emailID, String password) 
    {
        return UserList.getInstance().add(firstName, LastName, emailID,password);

    }

    public Boolean addTask(String taskName, String taskDesc, int priority, String title, User tester)
    {
        //return TaskList.getInstance().addTask(taskName);
        return TaskList.getInstance().add(taskName, taskDesc, priority,title,tester);
    }

    public Task getTask(String taskName)
    {
        task = TaskList.getInstance().getTask(taskName);
        return task;
    }

    public ArrayList<Task> getTasks()
    {
        return TaskList.getInstance().getTasks();
    }

    public User getUser()
    {
        return user;
    }

    public User getUserbyName(String firstName, String lastName){
        
        return user= UserList.getInstance().getUserbyName(firstName,lastName);
    }

    public Project getProject(String name) {
        project = ProjectBoard.getInstance().getProject(name);
        return project;
        
        //return projectBoard.getProject(name);
        //might need to do getInstance
    }

    public ArrayList<Project> getAllProjects() {
        return ProjectBoard.getInstance().getAllProjects();
    }

    public void addCommentProject(Project project) {

    }

    public void logout() {
        UserList.getInstance().saveUsers();
        TaskList.getInstance().saveTasks();
        DataWriter.saveProjects();
    }
    
    public void writeFile(ArrayList<Project> output , String fileName){
        try{
            FileWriter file = new FileWriter(fileName);
            
            for (Project project : output) {
                String projectStr = project.toString();
                file.write(projectStr);
            }
            file.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}