// John Ide - main frame for login view
package login;

import database.User_Table;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
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
        loginViewPanel.getTryAgainBooBooLabel().setVisible(false);
        add(loginViewPanel);
    }

    public void addLoginButtonListener(ActionListener al) {
        getLoginViewPanel().getLoginButton().addActionListener(al);
    }

    public void addLoginButtonKeyListener(KeyListener kl) {
        getLoginViewPanel().getPasswordTextField().addKeyListener(kl);
        getLoginViewPanel().getUsernameTextField().addKeyListener(kl);
    }

    public void addNewUserButtonListener(ActionListener al) {
        getLoginViewPanel().getNewUserButton().addActionListener(al);
    }

    public LoginViewPanel getLoginViewPanel() {
        return loginViewPanel;
    }
}
