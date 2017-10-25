/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import database.Login_Table;
import javax.swing.JFrame;

/**
 *
 * @author John
 */
public class LoginView extends JFrame {
    private Login_Table db;
    private LoginViewPanel loginViewPanel;
    
    public LoginView(Login_Table db) {
        super("Login");
        this.db = db;
        
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        loginViewPanel = new LoginViewPanel();
        add(loginViewPanel);
    }
    
    public LoginViewPanel getLoginViewPanel() {
        return loginViewPanel;
    }
}
