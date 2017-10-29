/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import app.NavCntl;
import app.NavView;
import database.User_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author John
 */
public class LoginCntl {
    private final User_Table db;
    private final LoginView loginView;
    
    private NavCntl navCntl;
    private NavView navView;
    
    private String username;
    private String password;
    
    public LoginCntl(User_Table db, LoginView loginView) {
        this.db = db;
        this.loginView = loginView;
        
        loginView.setVisible(true);
        
//        navView = new NavView();
//        navCntl = new NavCntl(getNavView());
        
        loginView.addLoginButtonListener(new LoginButtonListener());
        loginView.addLoginButtonKeyListener(new LoginButtonKeyListener());
        loginView.addNewUserButtonListener(new NewUserButtonListener());
    }
    
    public void authenticationProcess() {
        username = getLoginView().getLoginViewPanel().getUsernameTextField().getText();
        password = getLoginView().getLoginViewPanel().getPasswordTextField().getText();

        int accountID = db.authenticate(username, password);

        if(accountID != -1) {
            navView = new NavView();
            navCntl = new NavCntl(getNavView());
            getNavCntl().setAccountID(accountID);
            getNavCntl().setUser(db.getUserInfo(accountID));
            getLoginView().setVisible(false);
            getNavCntl().getNavView().setVisible(true);
        } else {
            getLoginView().getLoginViewPanel().getTryAgainBooBooLabel().setVisible(true);
        }
    }
    
    public class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            authenticationProcess();
        }
    }
    
    public class LoginButtonKeyListener implements KeyListener {
        // constructor to add a key listener
        public LoginButtonKeyListener() {
            loginView.getLoginViewPanel().addKeyListener(this);
        }
        
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == 10) authenticationProcess();
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }
    
    public class NewUserButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("new user button pressed");
            // TODO switch to new user page
        }
    }

    /**
     * @return the loginView
     */
    public LoginView getLoginView() {
        return loginView;
    }

    /**
     * @return the navCntl
     */
    public NavCntl getNavCntl() {
        return navCntl;
    }

    /**
     * @return the navView
     */
    public NavView getNavView() {
        return navView;
    }
}
