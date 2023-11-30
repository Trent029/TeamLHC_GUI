import java.sql.Date;
import java.util.UUID;

/**
 * Base for user comments
 */
public class Comment {
    public String comment;
    public Date date;
    public UUID userID;

    /**
     * Initializes a comment
     */
    public Comment(String Comment, User user) 
    {
        this.comment = Comment;
        this.userID = user.getId();
        this.date = new java.sql.Date(System.currentTimeMillis());
    }

    /**
     * Calls an existing comment
     * @param userID The uuid of a user
     * @param date The date the comment was made
     * @param Comment The comment that was entered
     */
    public Comment(UUID userID, Date date, String Comment)
    {
        this.comment = Comment;
        this.date = date;
        this.userID = userID;
    }



    /**
     * Edits a comment
     * @param comment The comment that was entered
     */
    public void editComment(String comment) {
        this.comment = comment;
    }

    /**
     * Get a user by their uuid
     * @return A user's ID
     */
    public UUID getUserID()
    {
        return this.userID;
    }

    /**
     * Returns the date a comment was made
     * @return The date for a comment
     */
    public Date getDate()
    {
        return this.date;
    }

    /**
     * Returns a comment
     * @return A comment
     */
    public String getComment()
    {
        return this.comment;
    }

    /**
     * Display the name of a user, the date they made a comment, and the specified comment
     * @return A string of a user, their comment date, and their comment
     */
    public String toString()
    {
        User tempUser = UserList.getInstance().getUser(this.userID);
        return tempUser.getFirstName() + "-" + tempUser.getLastName() + " Commented: " +this.getComment() + " -- Date "+this.getDate();
    }

}
