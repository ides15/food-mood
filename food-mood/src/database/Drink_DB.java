package database;

import foodmodel.Entry;
import java.util.ArrayList;

/**
 *
 * @author john
 */
public class Drink_DB extends Database {
    /**
     * Default constructor for drink database class.
     * @param TABLE the table to query from.
     */
    public Drink_DB(String TABLE) {
        
    }

    /**
     * Returns a single drink entry based on the query string 'entry'.
     * @param entry Query string for returning a drink entry.
     * @return Returns the drink entry.
     */
    @Override
    public String getEntry(String entry) {
        return "Food";
    }

    /**
     * Returns a list of drink entries.
     * @return Returns an Entry ArrayList of drink entries.
     */
    @Override
    public ArrayList<Entry> getAllEntries() {
        return new ArrayList<Entry>();
    }
}
