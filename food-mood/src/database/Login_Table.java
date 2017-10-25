package database;

import models.Entry;
import java.util.ArrayList;

/**
 *
 * @author john
 */
public class Login_Table extends Database {
    private int CURRENT_USER_ID;
    private final String DB_NAME;
    private final String URL;
    
    /**
     * Default constructor for login database class.
     * @param DB_NAME the table to query from.
     */
    public Login_Table(String DB_NAME) {
        this.DB_NAME = DB_NAME;
        this.URL = "jdbc:sqlite:" + DB_NAME;
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
}
