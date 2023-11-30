package model;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants
{

    public static void saveUsers()
    {
        
        UserList users = UserList.getInstance();
		ArrayList<User> userList = users.getUsers();

		JSONArray jsonUsers = new JSONArray();
		
        for(int i=0; i< userList.size(); i++) {
			jsonUsers.add(getUserJSON(userList.get(i)));
		}
		
        try (FileWriter file = new FileWriter("json/users.json")) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveTasks()
    {
        TaskList tasks = TaskList.getInstance();
		ArrayList<Task> taskList = tasks.getTasks();

		JSONArray jsonTasks = new JSONArray();
		
        for (int i=0; i<taskList.size(); i++) {
            jsonTasks.add(getTaskJSON(taskList.get(i)));
        }
		
        try (FileWriter file = new FileWriter(TASK_FILE_NAME)) {
 
            file.write(jsonTasks.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    public static JSONObject getTaskJSON(Task task)
    {
        JSONObject taskDetails = new JSONObject();
        taskDetails.put(TASK_ID,task.getTaskId().toString());
		taskDetails.put(TASK_NAME,task.getTaskName());
		taskDetails.put(TASK_DESCRIPTION, task.getTaskDescription());
		taskDetails.put(TASK_PRIORITY, Integer.toString(task.getTaskPriority()));
        
        if(task.getUsers()!=null)
        {
            JSONArray userids = new JSONArray();
            for(int i=0;i<task.getUsers().size();i++)
            {
                userids.add(i, task.getUsers().get(i).getId().toString());
            }
            taskDetails.put(TASK_USER_ID, userids);
        }
        else
        {
            taskDetails.put(TASK_USER_ID, "none");
        }
        
        JSONArray taskComments = new JSONArray();
        if(task.getTaskComments()!=null)
        {
            for(int i =0;i<task.getTaskComments().size();i++)
            {
                JSONObject comment = new JSONObject();
                comment.put(TASK_COMMENT_USER_ID,task.getTaskComments().get(i).getUserID().toString());
                comment.put(TASK_COMMENT_DATE,task.getTaskComments().get(i).getDate().toString());
                comment.put(TASK_COMMENT_STRING,task.getTaskComments().get(i).getComment());
                taskComments.add(comment);
                taskDetails.put(TASK_COMMENT, taskComments);
            }

        }
        else
        {
            JSONObject comment = new JSONObject();
            comment.put(TASK_COMMENT_USER_ID,"");
            comment.put(TASK_COMMENT_DATE,"");
            comment.put(TASK_COMMENT_STRING,"");
            taskComments.add(comment);
            taskDetails.put(TASK_COMMENT, taskComments);
        }

        if(task.getSubtasks()!=null)
        {
            JSONArray subtasks = new JSONArray();
            for(int i=0;i<task.subTasks.size();i++)
            {
                subtasks.add(i, task.getSubtasks().get(i));
            }
            taskDetails.put(TASK_SUBTASKS, subtasks);
        }
        else
        {
            taskDetails.put(TASK_SUBTASKS,null);
        }

        if (task instanceof Bug) {
            taskDetails.put(TASK_TITLE, ((Bug)task).getBug());
            taskDetails.put(TASK_TESTER, ((Bug)task).getTester().getId().toString());
        } else {
            taskDetails.put(TASK_TITLE, ((Feature)task).getFeature());
            taskDetails.put(TASK_TESTER, null);
        }
        

        return taskDetails;
    }

    public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_ID,user.getId().toString());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_EMAIL, user.getEmailID());
		userDetails.put(USER_PASSWORD, user.getPassword());
        
        return userDetails;
	}

    public static void saveProjects()
    {
        ArrayList<Project> projects = ProjectBoard.getInstance().getAllProjects();
		JSONArray jsonProjects = new JSONArray();
		
        for(int i=0; i < projects.size(); i++) {
			jsonProjects.add(getProjectJSON(projects.get(i)));
		}
		
        try (FileWriter file = new FileWriter(PROJECT_FILE_NAME)) {
 
            file.write(jsonProjects.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static JSONObject getProjectJSON(Project project) 
    {
		JSONObject projectDetails = new JSONObject();
		projectDetails.put(PROJECT_ID, project.getProjectID().toString());
        
        JSONArray userids = new JSONArray();
        for (int i=0; i<project.getUsers().size(); i++) {
            userids.add(i, project.getUsers().get(i).getId().toString());
        }
        projectDetails.put(PROJECT_USERS, userids);
        projectDetails.put(PROJECT_USER_SCRUMMASTER, project.getScrumMaster().getId().toString());
        projectDetails.put(PROJECT_USER_PRODUCTOWNER, project.getProductOwner().getId().toString());
        projectDetails.put(PROJECT_DESCRIPTION, project.getProjectDescription());
        projectDetails.put(PROJECT_NAME, project.getProjectName());

        JSONArray columns = new JSONArray();
        for (int i=0; i<project.getColumns().size(); i++) {
            JSONObject column = new JSONObject();
            column.put(PROJECT_COLUMN_NAME, project.getColumns().get(i).getName());
            JSONArray tasks = new JSONArray();
            if (project.getColumns().get(i).getTasks() != null) {
                    for (int j=0; j<project.getColumns().get(i).getTasks().size(); j++) {
                    tasks.add(j, project.getColumns().get(i).getTasks().get(j).getTaskId().toString());;
                }
            }
            
            column.put(PROJECT_COLUMN_NAME, project.getColumns().get(i).getName());
            column.put(PROJECT_COLUMN_TASKS, tasks);
            columns.add(column);
        }
		projectDetails.put(PROJECT_COLUMNS, columns);

        JSONArray comments = new JSONArray();
        for (int i=0; i<project.getComments().size(); i++) {
            JSONObject comment = new JSONObject();
            comment.put(PROJECT_COMMENT_USER_ID, project.getComments().get(i).getUserID().toString());
            comment.put(PROJECT_COMMENT_DATE, project.getComments().get(i).getDate().toString());
            comment.put(PROJECT_COMMENT_STRING, project.getComments().get(i).getComment());
            comments.add(comment);
        }
		projectDetails.put(PROEJCT_COMMENT, comments);


        return projectDetails;
        }
}
