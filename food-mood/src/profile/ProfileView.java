/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        populateUserInfo();
        add(profileViewPanel);
    }
    
    public void populateUserInfo() {
        // TODO        
    }
    
    public void addSaveButtonActionListener(ActionListener al) {
        profileViewPanel.getSaveButton().addActionListener(al);
    }
    
    public void addBackButtonActionListener(ActionListener al) {
        profileViewPanel.getBackButton().addActionListener(al);
    }

    /**
     * @return the profileViewPanel
     */
    public ProfileViewPanel getProfileViewPanel() {
        return profileViewPanel;
    }
}