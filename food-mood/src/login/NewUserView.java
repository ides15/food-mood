package login;

import database.User_Table;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author john
 */
public class NewUserView extends JFrame {
    private final User_Table db;
    private final NewUserViewPanel newUserViewPanel;
    
    public NewUserView(User_Table db) {
        super("New User");
        this.db = db;
        
        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        newUserViewPanel = new NewUserViewPanel();
        add(newUserViewPanel);
    }
    
    public void addNewSubmitButton(ActionListener al) {
        getNewUserViewPanel().getNewSubmitButton().addActionListener(al);
    }

    /**
     * @return the newUserViewPanel
     */
    public NewUserViewPanel getNewUserViewPanel() {
        return newUserViewPanel;
    }
}
