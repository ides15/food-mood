package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import parents.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import models.Mood;
import parents.Entry;

/**
 *
 * @author john
 */
public class Mood_Table extends Database {
    
    private DefaultTableModel moodData;
    private Mood mood;


    public Mood_Table(String TABLE) {
        super();
    }

    /*public Mood getUserMood(int accountID) {
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

        return new Mood(name);
    }*/

    public void addNewMood(Mood m, int accountID) {
        String sql = "INSERT INTO Moods (accountID, name, portion, date) VALUES (\"" + accountID + "\", \"" + m.getName() + "\", \"" + m.getPortion()+ "\", \"" + m.getDate() + "\");";
        
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
        System.out.println("getEntry called in Mood_DB.");
        return "Mood";
    }
    
    /**
     * Updates a food object to a new one in the sqlite database
     * @param name
     * @param portion
     * @param moodID
     */
    public void updateEntry(String name, String portion, int moodID){
        //update food entry in sql database
        String sql = "UPDATE Moods SET name = \"" + name + "\", portion = \"" + portion + "\" WHERE moodID = \"" + moodID + "\"";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteEntry(int moodID, int accountID) {
        //update mood entry in sql database
        String sql = "DELETE FROM Moods WHERE accountID = \"" + accountID + "\" AND moodID = \"" + moodID + "\"";
    
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getNumberOfMood(int accountID) {
        String sql = "SELECT name FROM Moods WHERE accountID = \"" + accountID + "\"";
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
    
    public DefaultTableModel getMoodList(int accountID){
        String sql = "SELECT name, moodID FROM Moods WHERE accountID = \"" + accountID + "\"";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
            Object[] columnNames = {
                "Mood Name", "Mood ID"
            };
            
            int numberOfMoods = this.getNumberOfMood(accountID);
            Object[][] data = new Object[numberOfMoods][2];
            
            for (int i = 0; i < numberOfMoods; i++) {
                rs.next();
                data[i][0] = rs.getString("name");
                data[i][1] = rs.getInt("moodID");
            }
            
            moodData = new DefaultTableModel(data, columnNames);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return moodData;
    }
    
    public String getPortionSize(int moodID, int accountID) {
        String sql = "SELECT portion FROM Moods WHERE moodID = \"" + moodID + "\"";
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
}
