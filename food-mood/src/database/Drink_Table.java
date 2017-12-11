package database;

import parents.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import parents.Entry;
import models.Drink;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author john
 */
public class Drink_Table extends Database {

    private DefaultTableModel drinkData;
    private Drink drink;

    /**
     * Default constructor for drink database class.
     *
     * @param TABLE the table to query from.
     */
    public Drink_Table(String TABLE) {
        super();
    }

    /**
     * Returns a single drink entry based on the query string 'entry'.
     *
     * @param entry Query string for returning a drink entry.
     * @return Returns the drink entry.
     */
    @Override
    public String getEntry(String entry) {
        System.out.println("getEntry called in Drink_DB.");
        return "Drink";
    }

    /**
     * Updates a drink object to a new one in the sqlite database
     *
     * @param name
     * @param portion
     * @param drinkID
     */
    public void updateEntry(String name, String portion, int drinkID) {
        //update drink entry in sql database
        String sql = "UPDATE Drinks SET name = \"" + name + "\", portion = \"" + portion + "\" WHERE drinkID = \"" + drinkID + "\"";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addEntry(Drink drink, int accountID) {
        String sql = "INSERT INTO Drinks (accountID, name, portion, date) VALUES (\"" + accountID + "\", \"" + drink.getName() + "\", \"" + drink.getPortion() + "\", \"" + drink.getDate() + "\")";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getPortionSize(int drinkID, int accountID) {
        String sql = "SELECT portion FROM Drinks WHERE drinkID = \"" + drinkID + "\"";
        String portion = "";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                portion = rs.getString("portion");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return portion;
    }

    /**
     * Returns a list of drink entries.
     *
     * @return Returns an Entry ArrayList of drink entries.
     */
    public ArrayList<Drink> getAllEntries(int accountID) {

        String sql = "SELECT * FROM Drinks WHERE accountID= \"" + accountID + "\"";
        String name = "name";
        String portion = "portion";
        String date = "date";
        String drinkID = "drinkID";
        ArrayList<Drink> drinkList = new ArrayList<>();
        Drink drink;

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("GET ALL ENTRIES");
            while (rs.next()) {
                drink = new Drink(rs.getString(name), rs.getString(portion), rs.getString(date), rs.getInt(drinkID));
                System.out.println("NAME: " + drink.getName() + " PORTION: " + drink.getPortion() + " DATE:" + drink.getDate());
                drinkList.add(drink);
                System.out.println("DrinkListSize: " + drinkList.size());
            }

            return drinkList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Drink getDrink(Drink f, int accountID) {
        String sql = "SELECT * FROM Drinks WHERE accountID= \"" + accountID + "\" AND name= \"" + f.getName() + "\" AND portion=\"" + f.getPortion() + "\" AND date=\"" + f.getDate() + "\";";
        String name = "name";
        String portion = "portion";
        String date = "date";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                name = rs.getString(name);
                portion = rs.getString(portion);
                date = rs.getString(date);
                System.out.println("NAME: " + name + " PORTION: " + portion + " DATE:" + date);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return f;
    }

    public String getLatestDrink(int accountID) {
        String sql = "SELECT MAX(drinkID), name FROM Drinks WHERE accountID = \"" + accountID + "\"";
        String name = "";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            name = rs.getString("name");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return name;
    }

    public int getNumberOfDrink(int accountID) {
        String sql = "SELECT name FROM Drinks WHERE accountID = \"" + accountID + "\"";
        int number = 0;

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                number++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return number;
    }

    public DefaultTableModel getDrinkList(int accountID) {
        String sql = "SELECT name, drinkID FROM Drinks WHERE accountID = \"" + accountID + "\"";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            Object[] columnNames = {
                "Drink Name", "Drink ID"
            };

            int numberOfDrinks = this.getNumberOfDrink(accountID);
            Object[][] data = new Object[numberOfDrinks][2];

            for (int i = 0; i < numberOfDrinks; i++) {
                rs.next();
                data[i][0] = rs.getString("name");
                data[i][1] = rs.getInt("drinkID");
            }

            drinkData = new DefaultTableModel(data, columnNames);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return drinkData;
    }

    public void deleteEntry(int drinkID, int accountID) {
        //update drink entry in sql database
        String sql = "DELETE FROM Drinks WHERE accountID = \"" + accountID + "\" AND drinkID = \"" + drinkID + "\"";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Entry> getAllEntries() {
        return null;
    }
}
