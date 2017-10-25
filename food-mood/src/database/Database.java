package database;

import models.Entry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

// TODO change names of child DBs to table, we won't be making a new database
// for each entry, change to Drink_Table or something similar

/**
 *
 * @author john
 */
abstract public class Database {
    private static final String URL = "";
    private final String DB_NAME = "";
    
    /**
     * Connects to the database.
     * @return returns the connection to the database.
     */
    protected Connection connectToDatabase() {
        System.out.println("connect called.");
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to db " + DB_NAME);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        return conn;
    }
    
    protected Connection connect() {
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
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