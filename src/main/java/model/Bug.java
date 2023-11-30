/**
 * Checks bugs in code and changes them
 * @author Sri Nandury
 */

import java.util.ArrayList;
import java.util.UUID;

public class Bug extends Task {
    
    public String bug;
    public User tester;

    /**
     * Inspects new bugs
     * @param name The name of the task
     * @param description Information about the task
     * @param priority The level of importance of the task
     * @param bug The name of the bug
     * @param tester The person testing the bug
     */
    Bug(String name, String description, int priority, String bug, User tester){
        super(name, description, priority);
        this.bug = bug;
        this.tester = tester;
    }

    /**
     * Inspects existing bugs
     * @param taskUUID The uuid of the task
     * @param users An array list of all current users
     * @param taskName The name of the task
     * @param taskDescription Information about the task
     * @param taskPriority The level of importance of the task
     * @param taskComments Comments from the task
     * @param subtasks Smaller tasks within the main task
     * @param bug The name of the bug
     * @param tester2 The person testing the bug
     */
    Bug(UUID taskUUID,ArrayList<User> users,String taskName, String taskDescription, int taskPriority, ArrayList<Comment> taskComments, ArrayList<String> subtasks, String bug, User tester2) {
        super(taskUUID, users, taskName, taskDescription, taskPriority, taskComments, subtasks);
        this.bug = bug;
        this.tester = tester2;
    }

    /**
     * Displays the bug
     * @return The name of the bug
     */
    public String getBug() {
        return this.bug;
    }

    /**
     * Changes the bug
     * @param bug The name of the bug
     */
    public void editBug(String bug) {
        this.bug = bug;
    }

    /**
     * Displays the bug tester
     * @return The person testing the bug
     */
    public User getTester() {
        return tester;
    }

    /**
     * Changes who is debugging the code
     * @param tester The person testing the bug
     */
    public void editTester(User tester) {
        this.tester = tester;
    }
}
