package LibraryManagment;
import java.sql.*;
public class UsersDAO {

        public boolean checkPassword(String userName,String Password) throws SQLException
        {
            ConnectionDB db=new ConnectionDB();
            String Query="select userName,password from users where username=? and password=?";
            PreparedStatement pst=db.con.prepareStatement(Query);
            pst.setString(1, userName);
            pst.setString(2, Password);
            ResultSet rs=pst.executeQuery();
            rs.next();
            try{
            return rs.getString(1)!=null&&rs.getString(2)!=null;
            }
            catch(SQLException e)
            {
            System.out.println("Wrong credentials Enter your details properly");
            return false;
            }
        }

    
    public Users returnUser(String userName, String password) throws SQLException {
        ConnectionDB db = new ConnectionDB();
        String query = "SELECT id, name, role, password, username FROM users WHERE username=? AND password=?";
        
        try (PreparedStatement pst = db.con.prepareStatement(query)) {
            pst.setString(1, userName);
            pst.setString(2, password);
    
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Users currentUser = new Users();
                    MapUser(currentUser,rs);
                    return currentUser;
                } else {
                    return null;
                }
            }
        }
    }
    
    public Users MapUser(Users CurrentUser,ResultSet rs) throws SQLException
    {
                    CurrentUser.id = rs.getInt(1);
                    CurrentUser.name = rs.getString(2);
                    CurrentUser.Role = rs.getString(3);
                    CurrentUser.Password = rs.getString(4);
                    CurrentUser.UserName = rs.getString(5);
                    return CurrentUser;

    }
}

           
