package Authentication;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Expense {
    public boolean addExpense(String category, double amount) {
        try (Connection conn = DB.getConnection()) {
            String query = "INSERT INTO EXPENSETRACKER (user_id, category, amount) VALUES (?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, category);
            pst.setDouble(2 ,amount);
            int rows = pst.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean editExpense(String category, double amount) {
        try (Connection conn = DB.getConnection()) {
            String query = "UPDATE EXPENSETRACKER SET category = ?, amount = ?";
            PreparedStatement pst= conn.prepareStatement(query);
            pst.setString(1, category);
            pst.setDouble(2, amount);
            int rows = pst.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteExpense(String category) {
        try (Connection conn = DB.getConnection()) {
            String query = "DELETE FROM EXPENSETRACKER WHERE category = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, category);
            int rows = pst.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


