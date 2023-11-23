package LibraryManagment;
import java.sql.*;
public class ConnectionDB {
    static Connection con;
    static Statement st;
    ConnectionDB() throws SQLException
    {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "12345678");
        st=con.createStatement();
    }
}
