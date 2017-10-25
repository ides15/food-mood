/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javax.swing.JPanel;

/**
 *
 * @author John
 */
public class LoginViewPanel extends JPanel {
    private UserLoginPanel userLoginPanel;
    
    public LoginViewPanel() {
        super();
        
        userLoginPanel = new UserLoginPanel();
        
        add(userLoginPanel);
    }

    /**
     * @return the userLoginPanel
     */
    public UserLoginPanel getUserLoginPanel() {
        return userLoginPanel;
    }

    /**
     * @param userLoginPanel the userLoginPanel to set
     */
    public void setUserLoginPanel(UserLoginPanel userLoginPanel) {
        this.userLoginPanel = userLoginPanel;
    }
}
