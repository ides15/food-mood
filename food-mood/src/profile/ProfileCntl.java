// John Ide - controller for user profile
package profile;

import database.User_Table;
import models.User;

/**
 *
 * @author John
 */
public class ProfileCntl {

    private User user;
    private final User_Table db;
    private final ProfileView profileView;

    public ProfileCntl(User_Table db, ProfileView profileView) {
        this.db = db;
        this.profileView = profileView;

        profileView.setVisible(true);
    }

    /**
     * @return the profileView
     */
    public ProfileView getProfileView() {
        return profileView;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
}
