package database;

import models.Entry;
import java.util.ArrayList;

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
}
