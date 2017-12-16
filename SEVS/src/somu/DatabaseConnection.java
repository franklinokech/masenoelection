package somu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DatabaseConnection extends JFrame {

    static final String JDBC = "com.mysql.jdbc.Driver";
    static final String DB = "jdbc:mysql://localhost:3306/somu";
   // static final String DB="jdbc:mysql://somu";
    static final String USER = "root";
    static final String PASS = "denoh";
    static Connection con = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    static ResultSet rs2 = null;
    //SET GLOBAL max_allowed_packet=1024*1024*14;

    public static void main(String args[]) {

    }

    public void dbConnect() throws SQLException {
        try {
            Class.forName(JDBC);
            con = DriverManager.getConnection(DB, USER, PASS);
            // JOptionPane.showMessageDialog(null, "connected");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);

        } catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException e) {
            JOptionPane.showMessageDialog(null, "Unable to establish a secure connection to the server, please review your network settings." + "\n" + "The application may load but"
                    + " transactions may  not occur untill connection is regained", "ERROR 404 Connection Failed", JOptionPane.ERROR_MESSAGE);

        } finally {
            try {
                if (con != null) {
                    //con.close();
                }
            } catch (Exception e) {
            }
        }

    }

}
