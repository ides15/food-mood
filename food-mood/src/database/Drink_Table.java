package database;

import models.Entry;
import java.util.ArrayList;

/**
 *
 * @author john
 */
public class Drink_Table extends Database {
    /**
     * Default constructor for drink database class.
     * @param TABLE the table to query from.
     */
    public Drink_Table(String TABLE) {
        System.out.println("Drink_DB constructor called.");
    }

    /**
     * Returns a single drink entry based on the query string 'entry'.
     * @param entry Query string for returning a drink entry.
     * @return Returns the drink entry.
     */
    @Override
    public String getEntry(String entry) {
        System.out.println("getEntry called in Drink_DB.");
        return "Food";
    }

    /**
     * Returns a list of drink entries.
     * @return Returns an Entry ArrayList of drink entries.
     */
    @Override
    public ArrayList<Entry> getAllEntries() {
        System.out.println("getAllEntries called in Drink_DB.");
        return new ArrayList<Entry>();
    }
}
