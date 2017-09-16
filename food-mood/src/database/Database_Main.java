package database;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author john
 */
public class Database_Main {
    private static final String URL = "";
    private String db_name = "";
    
    /**
     * Default constructor for the database class.
     */
    public Database_Main() {
        
    }
    
    /**
     * Connects to the database.
     * @return returns the connection to the database.
     */
    private Connection connect() {
        Connection conn = null;
        
        return conn;
    }
    
    /**
     * Returns all food that the user has logged.
     * @return returns all food in an array list.
     */
    public ArrayList<String> getAllFood() {
        return new ArrayList<String>();
    }
    
    /**
     * Returns all drink that the user has logged.
     * @return returns all drink in an array list.
     */
    public ArrayList<String> getAllDrink() {
        return new ArrayList<String>();
    }
    
    /**
     * Returns all moods that the user has logged.
     * @return returns all moods in an array list.
     */
    public ArrayList<String> getAllMoods() {
        return new ArrayList<String>();
    }
    
    /**
     * Persists a new food into the 
     * @param newFood 
     */
    public void addFood(String newFood) {
        
    }
}