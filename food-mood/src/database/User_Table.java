package database;

import parents.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.User;
import parents.Entry;

/**
 *
 * @author john
 */
public class User_Table extends Database {
    private int accountID = -1;
    
    /**
     * Default constructor for login database class.
     * @param DB_NAME the table to query from.
     */
    public User_Table(String DB_NAME) {
        super();
    }
    
    public int authenticate(String username, String password) {
        String sql = "SELECT password, accountID FROM Users WHERE username = \"" + username + "\"";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while(rs.next()) {
                if(rs.getString("password").equals(password)) {
                    setAccountID(rs.getInt("accountID"));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return getAccountID();
    }
    
    public User getUserInfo(int accountID) {
        String firstName = null,
                lastName = null,
                email = null,
                username = null,
                password = null;
        
        String sql = "SELECT firstName, lastName, email, username, password FROM Users WHERE accountID = \"" + accountID + "\"";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()) {
                firstName = rs.getString("firstName");
                lastName = rs.getString("lastName");
                email = rs.getString("email");
                username = rs.getString("username");
                password = rs.getString("password");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return new User(accountID, firstName, lastName, email, username, password);
    }
    
    public void setUserPassword(int accountID, String newPassword) {
        String sql = "UPDATE Users SET password = \"" + newPassword + "\" WHERE accountID = \"" + accountID + "\"";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @return the loginID
     */
    public int getAccountID() {
        return accountID;
    }

    /**
     * @param accountID the loginID to set
     */
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public String getEntry(String entry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Entry> getAllEntries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
