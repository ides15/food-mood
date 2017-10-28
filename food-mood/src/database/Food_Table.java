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
    
    private ArrayList<Food> foodList;
    
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
    public void setEntry(Food oldFood, Food newFood){
        //update food entry in sql database
        String sql = "UPDATE Food SET name = \""+newFood+"\", portion = \""+newFood.getAmount()+"\", date = \""+newFood.getDate()+"\" WHERE name= \""+oldFood.getName()+"\" AND portion=\""+oldFood.getAmount()+"\" AND date=\""+oldFood.getDate()+"\";";
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void addEntry(Food food){
        String sql = "INSERT INTO Food (name, portion, date) VALUES (\""+food.getName()+"\", \""+food.getAmount()+"\", \""+ food.getDate()+"\");";
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
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
    
    public ArrayList<Food> getFoodList(){
        String sql = "SELECT * FROM Food";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
            while(rs.next()) {
                //foodList = sql data;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return foodList;
    }
    
    public void deleteEntry(Food food){
        //update food entry in sql database
        String sql = "DELETE FROM Food WHERE name= \""+food.getName()+"\" AND portion=\""+food.getAmount()+"\" AND date=\""+food.getDate()+"\";";
    
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
