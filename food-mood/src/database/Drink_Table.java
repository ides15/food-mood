package database;

import parents.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    private Drink drink;
    private DefaultTableModel drinkData;

    public Drink_Table(String DB_NAME) {
        super();
    }

    public Drink getUserDrink(int accountID) {
        
        String name = null,
        date = null;
        int amount = 0;

        String sql = "SELECT name, amount, date FROM Users WHERE accountID = \"" + accountID + "\"";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                name = rs.getString("name");
                amount = rs.getInt("amount");
                date = rs.getString("date");
                accountID = rs.getInt("accountID");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Drink(name);
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
    
    public DefaultTableModel getDrinkList(int accountID){
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
    
    /**
     * @param d
     * @param accountID 
     * Adds a new Drink record in our drinks table
     */
    public void addNewDrink(Drink d, int accountID) {
        
        String sql = "INSERT INTO Drinks (accountID, name, portion, date) VALUES (\"" + accountID + "\", \"" + d.getDrink() + "\", \"" + d.getPortion()+ "\", \"" + d.getDate() + "\");";
        
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
     * @param accountID
     * @return portion
     */
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

    public void deleteEntry(int drinkID, int accountID) {
        String sql = "DELETE FROM drinks"
                + "WHERE accountID = \"" + accountID + "\" "
                + "AND drinkID = \"" + drinkID + "\"";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void updateEntry(String name, String portion, int drinkID){
        String sql = "UPDATE Drinks"
                + "SET name = \"" + name + "\", portion = \"" + portion + "\""
                + " WHERE drinkID = \"" + drinkID + "\"";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
