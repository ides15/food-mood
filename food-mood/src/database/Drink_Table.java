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

/**
 *
 * @author john
 */
public class Drink_Table extends Database {

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

    public void addNewDrink(Drink newDrink) {
        String sql = "INSERT INTO Drinks (name,amount, date, accountID) "
                + "VALUES (?, ?,?, ?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newDrink.getName());
            pstmt.setInt(2, newDrink.getAmount());
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
        return "Drink";
    }

    public void deleteEntry(Drink drink, int accountID) {
        //update food entry in sql database
        String sql = "DELETE FROM Foods WHERE accountID= \"" + accountID + "\" AND name= \"" + drink.getName() + "\" AND portion=\"" + drink.getAmount() + "\" AND date=\"" + drink.getDate() + "\";";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
