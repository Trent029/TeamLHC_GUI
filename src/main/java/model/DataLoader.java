package model;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Date;
/**
 * Data storage for users, projects, and tasks
 * @author Sri
 * @author Shruti
 */

public class DataLoader extends DataConstants{
	
	/**
	 * Get a list of users
	 * @return An array list of users
	 */
	public static ArrayList<User> getUsers(){
		ArrayList<User> users = new ArrayList<User>();
		try {
			FileReader reader = new FileReader(USER_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray peopleJSON = (JSONArray)parser.parse(reader);
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				String lastName = (String)personJSON.get(USER_LAST_NAME);
				String userEmail = (String)personJSON.get(USER_EMAIL);
				String userPassword = (String)personJSON.get(USER_PASSWORD);
				String firstName = (String)personJSON.get(USER_FIRST_NAME);
				UUID id = UUID.fromString((String)personJSON.get(USER_ID));
				users.add(new User(id, firstName, lastName, userEmail, userPassword));			
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Get a list of projects
	 * @return An array list of projects
	 */
    public static ArrayList<Project> getProjects()
	{
		ArrayList<Project> projects = new ArrayList<Project>();
		try {
			FileReader reader = new FileReader(PROJECT_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray projectsJSON = (JSONArray)parser.parse(reader);
			for(int i=0; i < projectsJSON.size(); i++) 
			{
				JSONObject projectJSON = (JSONObject)projectsJSON.get(i);
				UUID projectID = UUID.fromString((String)projectJSON.get(PROJECT_ID));
				String projectName = (String)projectJSON.get(PROJECT_NAME);
				String projectDescription = (String)projectJSON.get(PROJECT_DESCRIPTION);
				ArrayList<User> Users = new ArrayList<User>();
				JSONArray user = (JSONArray)projectJSON.get(PROJECT_USERS);
				for(int j=0;j<user.size();j++)
				{
					Users.add(UserList.getInstance().getUser(UUID.fromString((String)user.get(j))));
				}
				User scrumMaster = UserList.getInstance().getUser(UUID.fromString((String)projectJSON.get(PROJECT_USER_SCRUMMASTER)));
				User productOwner = UserList.getInstance().getUser(UUID.fromString((String)projectJSON.get(PROJECT_USER_PRODUCTOWNER)));
				ArrayList<Comment> projectComments = new ArrayList<Comment>();
				JSONArray comments = (JSONArray)projectJSON.get(PROEJCT_COMMENT);
				for(int j =0;j<comments.size();j++)
				{
					JSONObject commentJSON = (JSONObject)comments.get(j);
					UUID commentUserID = UUID.fromString((String)commentJSON.get(PROJECT_COMMENT_USER_ID));
					//Date date = Date.valueOf((String)commentJSON.get(PROJECT_COMMENT_DATE));
					String commentString = (String)commentJSON.get(PROJECT_COMMENT_DATE);
					//projectComments.add(new Comment(commentUserID, date, commentString));
				}
				ArrayList<Column> projectColumns = new ArrayList<Column>();
				JSONArray columns = (JSONArray)projectJSON.get(PROJECT_COLUMNS);
				for(int j =0;j<columns.size();j++)
				{
					JSONObject columnJSON = (JSONObject)columns.get(j);
					String columnName = (String)columnJSON.get(PROJECT_COLUMN_NAME);
					ArrayList<Task> columnTasks = new ArrayList<Task>();
					JSONArray columnTask = (JSONArray)columnJSON.get(PROJECT_COLUMN_TASKS);
					for(int k=0;k<columnTask.size();k++)
					{
						columnTasks.add(TaskList.getInstance().getTask(UUID.fromString((String)columnTask.get(k))));
					}
					Column column = new Column(columnName,columnTasks);
					projectColumns.add(column);
				}
				projects.add(new Project(projectID, projectName, projectDescription, projectColumns, projectComments, Users, scrumMaster, productOwner));			
			}
			return projects;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

/**
 * Get a list of tasks
 * @return An array list of tasks
 */	
 public static ArrayList<Task> getTasks()
	{
		ArrayList<Task> Tasks = new ArrayList<Task>();
		try {
			FileReader reader = new FileReader(TASK_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray TasksJSON = (JSONArray)parser.parse(reader);
			for(int i=0; i < TasksJSON.size(); i++) {
				JSONObject TaskJSON = (JSONObject)TasksJSON.get(i);
				UUID taskID = UUID.fromString((String)TaskJSON.get(TASK_ID));
				ArrayList<User> Users = new ArrayList<User>();
				JSONArray user = (JSONArray)TaskJSON.get(TASK_USER_ID);
				for(int j=0;j<user.size();j++)
				{
					Users.add(UserList.getInstance().getUser(UUID.fromString((String)user.get(j))));
				}
				String taskName = (String)TaskJSON.get(TASK_NAME);
				String taskDescription = (String)TaskJSON.get(TASK_DESCRIPTION);
				int taskPriority = Integer.parseInt((String)TaskJSON.get(TASK_PRIORITY));
				ArrayList<Comment> taskComments = new ArrayList<Comment>();
				JSONArray comments = (JSONArray)TaskJSON.get(TASK_COMMENT);
				for(int j =0;j<comments.size();j++)
				{
					JSONObject commentJSON = (JSONObject)comments.get(j);
					UUID commentUserID = UUID.fromString((String)commentJSON.get(TASK_COMMENT_USER_ID));
					//Date date = Date.valueOf((String)commentJSON.get(TASK_COMMENT_DATE));
					String commentString = (String)commentJSON.get(TASK_COMMENT_STRING);
					//taskComments.add(new Comment(commentUserID, date, commentString));
				}
				ArrayList<String> subtasks = new ArrayList<String>();
				JSONArray subtask = (JSONArray)TaskJSON.get(TASK_SUBTASKS);
				for(int j=0;j<subtask.size();j++)
				{
					subtasks.add((String)subtask.get(j));
				}
				String title = (String)TaskJSON.get(TASK_TITLE);
				User tester = null;
				if (TaskJSON.get(TASK_TESTER) != null)
					tester = UserList.getInstance().getUser(UUID.fromString((String)TaskJSON.get(TASK_TESTER)));
				Task task;
				if(tester!=null)
				{
					task = new Bug(taskID,Users,taskName,taskDescription,taskPriority,taskComments,subtasks,title,tester);
				}
				else
				{
					task = new Feature(taskID, Users, taskName, taskDescription, taskPriority, taskComments, subtasks, title);
				}
					Tasks.add(task);
			}
			return Tasks;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args)
	{
		System.out.println(getUsers().toString());
		System.out.println(getTasks().toString());
	}
}
