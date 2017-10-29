package login;

import database.User_Table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author john
 */
public class NewUserCntl {
    private final User_Table db;
    private final NewUserView newUserView;
    
    public NewUserCntl(User_Table db, NewUserView newUserView) {
        this.db = db;
        this.newUserView = newUserView;
        
        newUserView.setVisible(true);
        
        newUserView.addNewSubmitButton(new NewSubmitButtonListener());
    }
    
    public class NewSubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("submitted");
        }
    }
}
