package database;

import parents.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import parents.Entry;
import models.Food;
import java.util.ArrayList;

/**
 *
 * @author john
 */
public class Food_Table extends Database {
    
    private ArrayList<String> foodList;
    private Food food;
    
    /**
     * Default constructor for food database class.
     * @param TABLE the table to query from.
     */
    public Food_Table(String TABLE) {
        super();
    }
    
    /**
     * Returns a single food entry based on the query string 'entry'.
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
     * @param food 
     */
    public void updateEntry(Food oldFood, Food newFood, int accountID){
        //update food entry in sql database
        String sql = "UPDATE Foods SET name = \""+newFood+"\", portion = \""+newFood.getAmount()+"\", date = \""+newFood.getDate()+"\" WHERE accountID= \""+accountID+"\" AND name= \""+oldFood.getName()+"\" AND portion=\""+oldFood.getAmount()+"\" AND date=\""+oldFood.getDate()+"\";";
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void addEntry(Food food, int accountID){
        String sql = "INSERT INTO Foods (name, portion, date, accountID) VALUES (\""+food.getName()+"\", \""+food.getAmount()+"\", \""+ food.getDate()+"\", \""+accountID+"\");";
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Returns a list of food entries.
     * @return Returns an Entry ArrayList of food entries.
     */
    @Override
    public ArrayList<Entry> getAllEntries() {
        return null;
    }
    
    public Food getFood(Food f, int accountID){
        String sql = "SELECT * FROM Foods WHERE accountID= \""+accountID+"\" AND name= \""+f.getName()+"\" AND portion=\""+f.getAmount()+"\" AND date=\""+f.getDate()+"\";";
        String name = "name";
        String portion = "portion";
        String date = "date";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
            while(rs.next()) {
                name = rs.getString(name);
                portion = rs.getString(portion);
                date = rs.getString(date);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return f;
    }
    
    public ArrayList<String> getFoodList(int accountID){
        String sql = "SELECT * FROM Foods WHERE accountID = \""+accountID+"\";";
        String col = "name";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
            while(rs.next()) {
                foodList.add(rs.getString(col));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return foodList;
    }
    
    public void deleteEntry(Food food, int accountID){
        //update food entry in sql database
        String sql = "DELETE FROM Foods WHERE accountID = \"" + accountID + "\" AND name = \"" + food.getName() + "\" AND portion=\"" + food.getAmount() + "\" AND date=\"" + food.getDate() + "\";";
    
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
