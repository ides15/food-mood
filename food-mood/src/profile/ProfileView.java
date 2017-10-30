// John Ide - main frame for user profile page

package profile;

import database.User_Table;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import models.User;

/**
 *
 * @author John
 */
public class ProfileView extends JFrame {
    private User user;
    private final User_Table db;
    private final ProfileViewPanel profileViewPanel;
    
    public ProfileView(User_Table db) {
        super("Profile");
        this.db = db;
        
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        profileViewPanel = new ProfileViewPanel();
        add(profileViewPanel);
    }
    
    public void addSaveButtonActionListener(ActionListener al) {
        profileViewPanel.getSaveButton().addActionListener(al);
    }

    /**
     * @return the profileViewPanel
     */
    public ProfileViewPanel getProfileViewPanel() {
        return profileViewPanel;
    }
}
