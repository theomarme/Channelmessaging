package vincent.riva.channelmessaging;

import java.util.UUID;

/**
 * Created by rivav on 27/01/2017.
 */
public class Friend {
    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private UUID userID;
    private String username;
    private String imageUrl;
}
