package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import parents.Database;
import parents.Entry;
import java.util.ArrayList;
import models.Mood;

/**
 *
 * @author john
 */
public class Mood_Table extends Database {
    /**
     * Default constructor for mood database class.
     * @param TABLE the table to query from.
     */
    public Mood_Table(String TABLE) {
        super();
    }

    /**
     * Returns a single mood entry based on the query string 'entry'.
     * @param entry Query string for returning a mood entry.
     * @return Returns the mood entry.
     */
    @Override
    public String getEntry(String entry) {
        System.out.println("getEntry called in Mood_DB.");
        return "Mood";
    }

    /**
     * Returns a list of mood entries.
     * @return Returns an Entry ArrayList of mood entries.
     */
    @Override
    public ArrayList<Entry> getAllEntries() {
        System.out.println("getAllEntries called in Mood_DB.");
        return new ArrayList<Entry>();
    }
    
    public void deleteEntry(Mood mood, int accountID){
        //update food entry in sql database
        String sql = "DELETE FROM Foods WHERE accountID= \""+accountID+"\" AND name= \""+mood.getName()+"\" AND portion=\""+mood.getAmount()+"\" AND date=\""+mood.getDate()+"\";";
    
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
