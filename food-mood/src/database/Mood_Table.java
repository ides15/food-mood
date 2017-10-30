package database;

import parents.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Mood;
import models.User;
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
        int quantity = 0;

        String sql = "SELECT name, quantity, date FROM Users WHERE accountID = \"" + accountID + "\"";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                name = rs.getString("name");
                quantity = rs.getInt("quantity");
                date = rs.getString("date");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return new Mood(name, quantity, accountID);
    }

    public void setUserPassword(int accountID, String newPassword) {
        String sql = "UPDATE Users SET password = \"" + newPassword + "\" WHERE accountID = \"" + accountID + "\"";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addNewMood(Mood newMood) {
        String sql = "INSERT INTO Moods (name,quantity,date) "
                + "VALUES (?, ?, ?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newMood.getName());
            pstmt.setInt(2, newMood.getAmount());
            pstmt.setString(4, "March 3rd, 2013");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String getEntry(String entry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Entry> getAllEntries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
