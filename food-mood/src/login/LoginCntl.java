// John Ide - login controller

package login;

import app.NavCntl;
import app.NavView;
import app.NotificationView;
import database.User_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import models.User;

/**
 *
 * @author John
 */
public class LoginCntl {
    private final User_Table db;
    private final LoginView loginView;
    
    private NavCntl navCntl;
    private NavView navView;
    
    private NewUserCntl newUserCntl;
    private NewUserView newUserView;
    
    private NotificationView notificationView;
    
    private String username;
    private String password;
    
    public LoginCntl(User_Table db, LoginView loginView) {
        this.db = db;
        this.loginView = loginView;
        
        loginView.setVisible(true);
        
        loginView.addLoginButtonListener(new LoginButtonListener());
        loginView.addLoginButtonKeyListener(new LoginButtonKeyListener());
        loginView.addNewUserButtonListener(new NewUserButtonListener());
    }
    
    private void initNotification(int accountID) {
        User user = db.getUserInfo(accountID);
        getNotificationView().getNotificationViewPanel().getHelloLabel().setText("Hello " + user.getFirstName() + "!");
        
    }
    
    public void authenticationProcess() {
        username = getLoginView().getLoginViewPanel().getUsernameTextField().getText();
        password = getLoginView().getLoginViewPanel().getPasswordTextField().getText();

        int accountID = db.authenticate(username, password);

        if(accountID != -1) {
            navView = new NavView();
            notificationView = new NotificationView();
            getNotificationView().setAccountID(accountID);
            navCntl = new NavCntl(getNavView());
            getNavCntl().setAccountID(accountID);
            getNavCntl().setUser(db.getUserInfo(accountID));
            getLoginView().setVisible(false);
            getNavView().setVisible(true);
            getNotificationView().setVisible(true);
            initNotification(accountID);
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
            newUserView = new NewUserView(db);
            newUserCntl = new NewUserCntl(db, getNewUserView());
            getNewUserView().addNewSubmitButton(new NewSubmitButtonListener());
            getNewUserView().setVisible(true);
        }
    }
    
    public class NewSubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String newFirstName = getNewUserView().getNewUserViewPanel().getNewFirstNameTextField().getText();
            String newLastName = getNewUserView().getNewUserViewPanel().getNewLastNameTextField().getText();
            String newEmail = getNewUserView().getNewUserViewPanel().getNewEmailTextField().getText();
            String newUsername = getNewUserView().getNewUserViewPanel().getNewUsernameTextField().getText();
            String newPassword = getNewUserView().getNewUserViewPanel().getNewPasswordTextField().getText();
            
            // if all the text fields are empty, set the label on newUserViewPanel visible; else add the new user to the users table
            if(newFirstName.isEmpty() || newLastName.isEmpty() || newEmail.isEmpty() || newUsername.isEmpty() || newPassword.isEmpty()) {
                getNewUserView().getNewUserViewPanel().getFillOutFieldsLabel().setVisible(true);
            } else {
                User newUser = new User(-1, newFirstName, newLastName, newEmail, newUsername, newPassword);
                db.addNewUser(newUser);
                getNewUserView().setVisible(false);
            }
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

    /**
     * @return the newUserCntl
     */
    public NewUserCntl getNewUserCntl() {
        return newUserCntl;
    }

    /**
     * @return the newUserView
     */
    public NewUserView getNewUserView() {
        return newUserView;
    }

    /**
     * @return the notificationView
     */
    public NotificationView getNotificationView() {
        return notificationView;
    }
}
