package database;

import models.Entry;
import java.util.ArrayList;

/**
 *
 * @author john
 */
public class Food_DB extends Database {
    /**
     * Default constructor for food database class.
     * @param TABLE the table to query from.
     */
    public Food_DB(String TABLE) {
        
    }

    /**
     * Returns a single food entry based on the query string 'entry'.
     * @param entry Query string for returning a food entry.
     * @return Returns the food entry.
     */
    @Override
    public String getEntry(String entry) {
        return "Drink";
    }

    /**
     * Returns a list of food entries.
     * @return Returns an Entry ArrayList of food entries.
     */
    @Override
    public ArrayList<Entry> getAllEntries() {
        return new ArrayList<Entry>();
    }
}
