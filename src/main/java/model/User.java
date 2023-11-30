package model;
import java.util.UUID;

/**
 * User information
 */
public class User {
    private UUID uuid;
    private String firstName;
    private String lastName;
    public String userEmail;
    private String userPassword;
    
    /**
     * Existing users
     * @param uuid The ID of a usegir
     * @param firstName The user's first name
     * @param lastName The user's last name
     * @param userEmail The user's email
     * @param userPassword The user's password
     */
    public User(UUID uuid, String firstName, String lastName, String userEmail, String userPassword) {
       this.uuid = uuid;
       this.firstName = firstName;
       this.lastName = lastName;
       this.userEmail = userEmail;
       this.userPassword = userPassword;
    }

    /**
     * New users
     * @param firstName The user's first name
     * @param lastName The user's last name
     * @param userEmail The user's email
     * @param userPassword The user's password
     */
    public User(String firstName, String lastName, String userEmail, String userPassword) {
    
       this.uuid = UUID.randomUUID();
       this.firstName = firstName;
       this.lastName = lastName;
       this.userEmail = userEmail;
       this.userPassword = userPassword;
    }

    /**
     * Enters the information of a user
     * @return The user's ID, first and last name, email, and password
     */
    public String toString()
    {
        return "Username: "+this.firstName+" "+this.lastName+" Email:"+this.userEmail;
    }

    /**
     * Gets the user's ID
     * @return The uuid of a user
     */
    public UUID getId() {
        return this.uuid;
    }

    /**
     * Gets the user's first name
     * @return The first name of a user
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets the user's last name
     * @return The last name of a user
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Gets the user's email
     * @return The email of a user
     */
    public String getEmailID() {
        return this.userEmail;
    }

    /**
     * Gets the user's password
     * @return The password of a user
     */
    public String getPassword() {
        return this.userPassword;
    }

    
}
