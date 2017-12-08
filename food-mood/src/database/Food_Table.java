package database;

import parents.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import parents.Entry;
import models.Food;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author john
 */
public class Food_Table extends Database {

    private DefaultTableModel foodData;
    private Food food;

    /**
     * Default constructor for food database class.
     *
     * @param TABLE the table to query from.
     */
    public Food_Table(String TABLE) {
        super();
    }

    /**
     * Returns a single food entry based on the query string 'entry'.
     *
     * @param entry Query string for returning a food entry.
     * @return Returns the food entry.
     */
    @Override
    public String getEntry(String entry) {
        System.out.println("getEntry called in Food_DB.");
        return "Drink";
    }

    /**
     * Updates a food object to a new one in the sqlite database
     *
     * @param name
     * @param portion
     * @param foodID
     */
    public void updateEntry(String name, String portion, int foodID) {
        //update food entry in sql database
        String sql = "UPDATE Foods SET name = \"" + name + "\", portion = \"" + portion + "\" WHERE foodID = \"" + foodID + "\"";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addEntry(Food food, int accountID) {
        String sql = "INSERT INTO Foods (accountID, name, portion, date) VALUES (\"" + accountID + "\", \"" + food.getName() + "\", \"" + food.getPortion() + "\", \"" + food.getDate() + "\")";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getPortionSize(int foodID, int accountID) {
        String sql = "SELECT portion FROM Foods WHERE foodID = \"" + foodID + "\"";
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
     * Returns a list of food entries.
     *
     * @return Returns an Entry ArrayList of food entries.
     */
    public ArrayList<Food> getAllEntries(int accountID) {

        String sql = "SELECT * FROM Foods WHERE accountID= \"" + accountID + "\"";
        String name = "name";
        String portion = "portion";
        String date = "date";
        String foodID = "foodID";
        ArrayList<Food> foodList = new ArrayList<Food>();
        Food food;

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("GET ALL ENTRIES");
            while (rs.next()) {
                food = new Food(rs.getString(name), rs.getString(portion), rs.getString(date), rs.getInt(foodID));
                System.out.println("NAME: " + food.getName() + " PORTION: " + food.getPortion() + " DATE:" + food.getDate());
                foodList.add(food);
                System.out.println("FoodListSize: " + foodList.size());
            }

            return foodList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Food getFood(Food f, int accountID) {
        String sql = "SELECT * FROM Foods WHERE accountID= \"" + accountID + "\" AND name= \"" + f.getName() + "\" AND portion=\"" + f.getPortion() + "\" AND date=\"" + f.getDate() + "\";";
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

    public String getLatestFood(int accountID) {
        String sql = "SELECT MAX(foodID), name FROM Foods WHERE accountID = \"" + accountID + "\"";
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

    public int getNumberOfFood(int accountID) {
        String sql = "SELECT name FROM Foods WHERE accountID = \"" + accountID + "\"";
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

    public DefaultTableModel getFoodList(int accountID) {
        String sql = "SELECT name, foodID FROM Foods WHERE accountID = \"" + accountID + "\"";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            Object[] columnNames = {
                "Food Name", "Food ID"
            };

            int numberOfFoods = this.getNumberOfFood(accountID);
            Object[][] data = new Object[numberOfFoods][2];

            for (int i = 0; i < numberOfFoods; i++) {
                rs.next();
                data[i][0] = rs.getString("name");
                data[i][1] = rs.getInt("foodID");
            }

            foodData = new DefaultTableModel(data, columnNames);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return foodData;
    }

    public void deleteEntry(int foodID, int accountID) {
        //update food entry in sql database
        String sql = "DELETE FROM Foods WHERE accountID = \"" + accountID + "\" AND foodID = \"" + foodID + "\"";

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
