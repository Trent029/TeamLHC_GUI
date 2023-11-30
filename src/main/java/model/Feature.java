/**
 * Checks features in code and changes them
 * @author Sri Nandury
 */

import java.util.ArrayList;
import java.util.UUID;

public class Feature extends Task{
    
    public String feature;

    /**
     * New feature
     * @param name The name of the task
     * @param description Information about the task
     * @param priority The level of importance of the task
     * @param feature The name of the feature
     */
    public Feature(String name, String description, int priority, String feature){
        super(name, description, priority);
        this.feature = feature;
    }

    /**
     * Existing feature
     * @param taskUUID The uuid of the task
     * @param users An array list of all current users
     * @param taskName The name of the task
     * @param taskDescription Information about the task
     * @param taskPriority The level of importance of the task
     * @param taskComments Comments from the task
     * @param subtasks Smaller tasks within the main task
     * @param feature The name of the feature
     */
    public Feature(UUID taskUUID,ArrayList<User> users,String taskName, String taskDescription, int taskPriority, ArrayList<Comment> taskComments, ArrayList<String> subtasks, String feature) {
        super(taskUUID, users, taskName, taskDescription, taskPriority, taskComments, subtasks);
        this.feature = feature;
    }

    /**
     * Displays the feature
     * @return The name of the feature
     */
    public String getFeature() {
        return this.feature;
    }

    /**
     * Changes the feature
     * @param feature The name of the feature
     */
    public void editFeature(String feature) {
        this.feature = feature;
    }
}
