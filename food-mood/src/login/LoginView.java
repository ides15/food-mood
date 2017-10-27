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
    private final User_Table db;
    private final LoginViewPanel loginViewPanel;
    
    public LoginView(User_Table db) {
        super("Login");
        this.db = db;
        
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        loginViewPanel = new LoginViewPanel();
        loginViewPanel.getUserLoginPanel().getTryAgainBooBooLabel().setVisible(false);
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
