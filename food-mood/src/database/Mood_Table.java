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

    public Mood_Table(String DB_NAME) {
        super();
    }

    public Mood getUserMood(int accountID) {
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
    }

    public void addNewMood(Mood newMood) {
        String sql = "INSERT INTO Moods (name,amount, date, accountID) "
                + "VALUES (?, ?,?, ?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newMood.getName());
            pstmt.setInt(2, newMood.getAmount());
            pstmt.setString(3, "March 3rd, 2013");
            pstmt.setInt(4, 103);
            pstmt.executeUpdate();
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
        System.out.println("getEntry called in Food_DB.");
        return "Mood";
    }

    public void deleteEntry(Mood mood, int accountID) {
        //update food entry in sql database
        String sql = "DELETE FROM Foods WHERE accountID= \"" + accountID + "\" AND name= \"" + mood.getName() + "\" AND portion=\"" + mood.getAmount() + "\" AND date=\"" + mood.getDate() + "\";";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
