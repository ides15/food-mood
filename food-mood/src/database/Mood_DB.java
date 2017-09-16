package database;

import foodmodel.Entry;
import java.util.ArrayList;

/**
 *
 * @author john
 */
public class Mood_DB extends Database {
    /**
     * Default constructor for mood database class.
     * @param TABLE the table to query from.
     */
    public Mood_DB(String TABLE) {
        
    }

    /**
     * Returns a single mood entry based on the query string 'entry'.
     * @param entry Query string for returning a mood entry.
     * @return Returns the mood entry.
     */
    @Override
    public String getEntry(String entry) {
        return "Mood";
    }

    /**
     * Returns a list of mood entries.
     * @return Returns an Entry ArrayList of mood entries.
     */
    @Override
    public ArrayList<Entry> getAllEntries() {
        return new ArrayList<Entry>();
    }
}
