package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import models.Drink_bk;
import parents.Database;
import parents.Entry;

/**
 *
 * @author john
 */
public class Drink_Table_bk extends Database {

    private Drink_bk drink;
    private DefaultTableModel drinkData;

    public Drink_Table_bk(String DB_NAME) {
        super();
    }

    public ArrayList<Drink_bk> getAllEntries(int accountID) {

        String sql = "SELECT name,portion,date,drinkID FROM Drinks WHERE accountid= \"" + accountID + "\"";
        String name = "name";
        String portion = "portion";
        String date = "date";
        String drinkID = "drinkID";
        ArrayList<Drink_bk> drinkList = new ArrayList<>();

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("GET ALL ENTRIES");
            while (rs.next()) {
                drink = new Drink_bk(rs.getString(name), rs.getString(portion), rs.getString(date), rs.getInt(drinkID));
                drinkList.add(drink);
            }

            return drinkList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Drink_bk getDrink(Drink_bk f, int accountID) {
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
        String sql = "SELECT MAX(drinkID), name FROM Drinks WHERE accountid = \"" + accountID + "\"";
        String drink = "";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            drink = rs.getString("name");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return drink;
    }

    public int getNumberOfDrink(int accountID) {
        String sql = "SELECT name FROM Drinks WHERE accountid = \"" + accountID + "\"";
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
        String sql = "SELECT name, drinkID FROM Drinks WHERE accountid = \"" + accountID + "\"";

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

    /**
     * @param d
     * @param accountID Adds a new Drink_bk record in our drinks table
     */
    public void addNewDrink(Drink_bk d, int accountID) {

        String sql = "INSERT INTO Drinks (accountID, name, portion, date) VALUES (\"" + accountID + "\", \"" + d.getDrink() + "\", \"" + d.getPortion() + "\", \"" + d.getDate() + "\");";

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

    @Override
    public String getEntry(String entry) {
        System.out.println("getEntry called in Drink_DB.");
        return "Drink";
    }

    /**
     *
     * @param drinkID
     * @return portion
     */
    public String getPortionSize(int drinkID) {
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

    public void deleteEntry(int drinkID) {
        String sql = "DELETE FROM Drinks WHERE drinkID = \"" + drinkID + "\"";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateEntry(String name, String portion, int drinkID) {
        String sql = "UPDATE Drinks SET name = \"" + name + "\", portion = \"" + portion + "\" WHERE drinkID = \"" + drinkID + "\"";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
