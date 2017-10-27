/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profile;

import database.User_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        profileView.addSaveButtonActionListener(new SaveButtonListener());
        profileView.addBackButtonActionListener(new BackButtonListener());
    }
    
    public class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("save");
        }
    }
    
    public class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("back");
        }
    }

    /**
     * @return the profileView
     */
    public ProfileView getProfileView() {
        return profileView;
    }
}
