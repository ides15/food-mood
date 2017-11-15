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
import models.Mood;
import parents.Entry;

/**
 *
 * @author john
 */
public class Mood_Table extends Database {
    
    private ArrayList<String> moodList;
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

    public void deleteEntry(String name, int accountID) {
        //update mood entry in sql database
        String sql = "DELETE FROM Moods WHERE accountID = \"" + accountID + "\" AND name = \"" + name + "\"";
    
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ArrayList<String> getMoodList(int accountID){
        String sql = "SELECT * FROM Moods WHERE accountID = \"" + accountID + "\";";
        String col = "name";
        
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            
            moodList = new ArrayList<>();
            while(rs.next()) {
                moodList.add(rs.getString(col));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return moodList;
    }
}
