package app;

import database.User_Table;
import login.LoginCntl;
import login.LoginView;

/**
 *
 * @author john
 */
public class Main {

    public static void main(String[] args) {
        User_Table db = new User_Table("foodmood.db");
        LoginView loginView = new LoginView(db);
        LoginCntl loginCntl = new LoginCntl(db, loginView);
    }
}
