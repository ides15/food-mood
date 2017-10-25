/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import database.User_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author John
 */
public class LoginCntl {
    private final User_Table db;
    private final LoginView loginView;
    
    private LoginViewPanel loginViewPanel;
    
    private final UserLoginPanel userLoginPanel;
    
    private String username;
    private String password;
    
    public LoginCntl(User_Table db, LoginView loginView) {
        this.db = db;
        this.loginView = loginView;
        
        loginView.setVisible(true);
        
        userLoginPanel = new UserLoginPanel();
        
        loginView.addLoginButtonListener(new LoginButtonListener());
        loginView.addNewUserButtonListener(new NewUserButtonListener());
    }
    
    class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            username = loginView.getLoginViewPanel().getUserLoginPanel().getUsernameTextField().getText();
            password = loginView.getLoginViewPanel().getUserLoginPanel().getPasswordTextField().getText();
            
            int loginID = db.authenticate(username, password);
            
            if(loginID != -1) {
                System.out.println("user authenticated");
            }
        }
    }
    
    class NewUserButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO switch to new user page
        }
    }
}
