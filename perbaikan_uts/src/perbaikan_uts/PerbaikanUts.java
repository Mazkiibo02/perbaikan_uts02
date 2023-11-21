package perbaikan_uts;

import koneksi.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PerbaikanUts {
    public static void main(String[] args) {
        // Example usage of the connection
        Connection conn = KoneksiDatabase.bukaKoneksi(); // Log the exception details (consider using a logging framework)
        // Display a more user-friendly error message
        // Your SQL query here
        String query = "INSERT INTO mhs (id, nim, nama, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            // Set values for your prepared statement
            pst.setInt(1, 1); // Replace 1 with the actual value for the id column
            pst.setInt(2, 22090133); // Replace 1234567890 with the actual value for the nim column
            pst.setString(3, "Hafidz Rahamtullah"); // Replace "John Doe" with the actual value for the nama column
            pst.setString(4, "vdz.rach03@gmail.com"); // Replace "john.doe@example.com" with the actual value for the email column
            
            // Execute the query
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data inserted successfully");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

    }
}
