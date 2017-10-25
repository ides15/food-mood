/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import database.User_Table;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author John
 */
public class LoginView extends JFrame {
    private User_Table db;
    private LoginViewPanel loginViewPanel;
    
    public LoginView(User_Table db) {
        super("Login");
        this.db = db;
        
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        loginViewPanel = new LoginViewPanel();
        add(loginViewPanel);
    }
    
    public void addLoginButtonListener(ActionListener al) {
        getLoginViewPanel().getUserLoginPanel().getLoginButton().addActionListener(al);
    }
    
    public void addNewUserButtonListener(ActionListener al) {
        getLoginViewPanel().getUserLoginPanel().getNewUserButton().addActionListener(al);
    }
    
    public LoginViewPanel getLoginViewPanel() {
        return loginViewPanel;
    }
}
