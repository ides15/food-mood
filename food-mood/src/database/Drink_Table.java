package database;

import parents.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import parents.Entry;
import models.Drink;
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
        super();
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
    
    public void deleteEntry(Drink drink, int accountID){
        //update food entry in sql database
        String sql = "DELETE FROM Foods WHERE accountID= \""+accountID+"\" AND name= \""+drink.getName()+"\" AND portion=\""+drink.getAmount()+"\" AND date=\""+drink.getDate()+"\";";
    
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
