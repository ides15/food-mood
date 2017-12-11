// John Ide - controller for the new user page
package login;

import database.User_Table;

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
    }
}
