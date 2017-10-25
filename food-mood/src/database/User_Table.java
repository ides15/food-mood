package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Entry;
import java.util.ArrayList;

/**
 *
 * @author john
 */
public class User_Table extends Database {
    private int loginID = -1;
    
    /**
     * Default constructor for login database class.
     * @param DB_NAME the table to query from.
     */
    public User_Table(String DB_NAME) {
        super();
    }
    
    public int authenticate(String username, String password) {
        String sql = "SELECT password, account_id FROM Users WHERE username = \"" + username + "\"";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
            while(rs.next()) {
                if(rs.getString("password").equals(password)) {
                    setLoginID(rs.getInt("account_id"));
                    System.out.println("account id in database: " + getLoginID());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return getLoginID();
    }

    /**
     * Returns a single login entry based on the query string 'entry'.
     * @param entry Query string for returning a login entry.
     * @return Returns the login entry.
     */
    @Override
    public String getEntry(String entry) {
        return "Food";
    }

    /**
     * Returns a list of login entries.
     * @return Returns an Entry ArrayList of login entries.
     */
    @Override
    public ArrayList<Entry> getAllEntries() {
        return new ArrayList<Entry>();
    }

    /**
     * @return the loginID
     */
    public int getLoginID() {
        return loginID;
    }

    /**
     * @param loginID the loginID to set
     */
    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }
}
