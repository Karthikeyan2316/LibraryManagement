package LibraryManagment;
import java.sql.*;
import java.util.*;
import java.util.Date;
public class TransactionDAO {
    TransactionDAO(){}
    public ResultSet DisplayTransactions() throws SQLException 
    {
        ConnectionDB db=new ConnectionDB();
        return db.st.executeQuery("select * transactions");
    }
    public void addTransaction(Users CurrentUser,int bookdId,int copies) throws SQLException
    {
        ConnectionDB db=new ConnectionDB();
        String Query0="select getBookName(?)";
        PreparedStatement pst1=db.con.prepareStatement(Query0);
        pst1.setInt(1, bookdId);
        ResultSet rs1=pst1.executeQuery();
        rs1.next();
        String BookName=rs1.getString(1);
        Date date=new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String Query1="insert into transactions(bookName,userName,userId,copies,issueDate) values(?,?,?,?,?);";

        PreparedStatement pst2=db.con.prepareStatement(Query1);
        pst2.setString(1, BookName);
        pst2.setString(2, CurrentUser.UserName);
        pst2.setInt(3, CurrentUser.id);
        pst2.setInt(4,copies );
        pst2.setDate(5,sqlDate);
        pst2.executeUpdate();
}
}



//for Admin purpose only this DAOclass !!!