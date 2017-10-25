/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import database.Login_Table;

/**
 *
 * @author John
 */
public class LoginCntl {
    private Login_Table db;
    private LoginView loginView;
    
    private LoginViewPanel loginViewPanel;
    
    private UserLoginPanel userLoginPanel;
    
    private String username;
    private String password;
    
    public LoginCntl(Login_Table db, LoginView loginView) {
        this.db = db;
        this.loginView = loginView;
        
        loginView.setVisible(true);
        
        userLoginPanel = new UserLoginPanel();
    }
}
