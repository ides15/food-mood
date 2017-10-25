package app;

import database.Login_Table;
import login.LoginCntl;
import login.LoginView;

/**
 *
 * @author john
 */
public class Main {

    public static void main(String[] args) {
        Login_Table db = new Login_Table("foodmood_login.db");
        LoginView loginView = new LoginView(db);
        LoginCntl loginCntl = new LoginCntl(db, loginView);
    }
}