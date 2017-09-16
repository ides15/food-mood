package database;

import models.Entry;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author john
 */
abstract public class Database {
    private static final String URL = "";
    private String db_name = "";
    
    /**
     * Connects to the database.
     * @return returns the connection to the database.
     */
    protected Connection connect() {
        Connection conn = null;
        
        return conn;
    }
    
    /**
     * Returns a single entry based on the query string 'entry'.
     * @param entry Query string for returning an entry.
     * @return Returns the entry.
     */
    abstract public String getEntry(String entry);
    
    /**
     * Returns a list of entries.
     * @return Returns a an ArrayList of object entries.
     */
    abstract public ArrayList<Entry> getAllEntries();
}