package model;
import java.util.ArrayList;
import java.util.UUID;

/**
 * A list of users
 */
public class UserList {
    private ArrayList<User> users;
    private static UserList userList;

    /**
     * Creates a list of users
     */
    public UserList() 
    {
        users= DataLoader.getUsers();
    }

    /**
     * Get instance of a user list
     * @return A list of users, whether new or existing
     */
    public static UserList getInstance() 
    {
        if(userList == null){
            userList = new UserList();
        }
        return userList;
    }

    /**
     * Get a user from the list by their email and password
     * @param userEmail The user's email
     * @param userPassword The user's password
     * @return The user with the email and password (if both exist)
     */
    public User getUser(String userEmail, String userPassword) {
        
        for(int i=0;i<users.size();i++)
        {
            //User user = users.get(i);
            if(users.get(i).getEmailID().equalsIgnoreCase(userEmail) && users.get(i).getPassword().equalsIgnoreCase(userPassword))
            {
                return users.get(i);
            }
        }
        return null;
    }

    /**
     * Add a user
     * @param emailID The user's email
     * @return True if there is not already a user with the email
     */
    public boolean addUser(String emailID)
    {
        users = DataLoader.getUsers();
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).userEmail.equalsIgnoreCase(emailID))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Add a user to the list
     * @param firstName The user's first name
     * @param lastName The user's last name
     * @param userEmail The user's email
     * @param userPassword The user's password
     * @return True always, and adds a user to the array list if user can be added (addUser String)
     */
    public boolean add(String firstName, String lastName, String userEmail, String userPassword)
    {
        User user = new User(firstName, lastName, userEmail, userPassword);
        if(addUser(userEmail))
        {
            users.add(user);
        }
        return true;
    }
    /**
     * Save the users in the data writer
     */
    public void saveUsers()
    {
        DataWriter.saveUsers();
    }

    /**
     * Get all users from the list
     * @return An array list of all users
     */
    public ArrayList<User> getUsers()
    {
        return users;
    }
    
    /**
     * Get a user by their uuid
     * @param id The uuid of a user
     * @return The user with the uuid (if it exists)
     */
    public User getUser(UUID id)
    {
        for(int i=0; i<users.size(); i++)
        {
            if(users.get(i).getId().equals(id))
                return users.get(i);
        }
        return null;
    }

    public User getUserbyName(String firstName, String lastName)
    {
        for(int i=0; i<users.size(); i++)
        {
            if(users.get(i).getFirstName().equalsIgnoreCase(firstName) && users.get(i).getLastName().equalsIgnoreCase(lastName))
                return users.get(i);
        }
        return null;
    }

}
