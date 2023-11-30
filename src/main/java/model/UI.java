package model;
//import java.util.Scanner;

import java.util.UUID;

public class UI {
    //private Scanner scanner;
    private ProjectFACADE app;

    public void run() {
        app = new ProjectFACADE();


        app.signUp("Atticus", "Madden", "amadden@gmail.com", "12345");
        app.getTasks();
        app.logout();
        app.login("amadden@gmail.com", "12345");
        User currentUser = app.getUser();
        System.out.print("Logged in as: " + currentUser.getFirstName()+" "+currentUser.getLastName());
        System.out.println(" working for Code Mission Impossible");

        Project currentProject = app.getProject("Electric Missiles");
        System.out.println("Current Project: "+currentProject.getProjectName());
        Task task = new Feature("Initialize super algorithm to detonate at warp speed","going fast is good",1,"warp speed");
        currentProject.addTask(task);
        
        task.addComment(new Comment("Avoid Civilians Jeff", currentUser));
        currentProject.addColumn(new Column("Abandoned"));

        Task task1 = currentProject.getTask("Make impossible burger possible");
        //System.out.println(task1);
        currentProject.moveTask(task1, "Abandoned");


        Task getTask = currentProject.getTask("Curve the metal to make a cylindrical shape");
        currentProject.moveTask(getTask, "Doing");
        TaskList.getInstance().getTask("Curve the metal to make a cylindrical shape").addComment(new Comment("How about you do it, Jeff", currentUser));

        User jeff = app.getUserbyName("Jeff", "Goldblum");
        System.out.println(jeff);

        TaskList.getInstance().getTask("Curve the metal to make a cylindrical shape").changeUser(jeff,currentUser);
        
        


        app.writeFile(app.getAllProjects(),"scrumboard.txt");
       // System.out.println(app.getAllProjects());

        app.logout();//to save the tasks to json file
        System.out.println(getTask);
        
    }
    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }
}