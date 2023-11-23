package LibraryManagment;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;

public class BooksDAO {
    //Displaying all the available books
    public ResultSet displayAvailableBooks() throws SQLException
    {
        try{
        ConnectionDB db=new ConnectionDB();
        return db.st.executeQuery("select * from books where copies>0");
        }
        catch(Exception e)
        {
            System.out.println("Currently Some Server Problem!!Sorry for the inconvience");
            return null;
        }

    }

    //mapping books pupose
    public Books mapBooks(int id) throws SQLException
    {
        try{
        Books book=new Books();
        ConnectionDB db=new ConnectionDB();
        String Query="select * from books where bookdId=?";
        PreparedStatement pst=db.con.prepareStatement(Query);
        pst.setInt(1, id);
        ResultSet rs=pst.executeQuery();
        rs.next();
        book.bookId=rs.getInt(1);
        book.bookName=rs.getString(2);
        book.Author=rs.getString(3);
        book.copies=rs.getInt(4);
        return book;
        }
        catch(SQLException e)
        {
            return null;
        }
    }
    ///reducing the count of books in database
    public boolean bookMinus(int bookdId,int copies,Users CurrentUser) throws SQLException
    {
        try{
        ConnectionDB db=new ConnectionDB();
        //counts
        String check="select getCounts(?)";
        PreparedStatement pst1=db.con.prepareStatement(check);
        pst1.setInt(1, bookdId);
        ResultSet rs1=pst1.executeQuery();
        rs1.next();
        int availableCopies=0;
            if(rs1!=null)
            {
                availableCopies=rs1.getInt(1);
            }
        //updations
        if(availableCopies>copies)
        {
        String Query="update books set copies=copies-? where bookdId=?";
        PreparedStatement pst2=db.con.prepareStatement(Query);
        pst2.setInt(1, copies);
        pst2.setInt(2, bookdId);
        pst2.executeUpdate();
        return true;
       
    }
}
    catch(Exception e)
    {
       System.out.println("Some error while transaction!!!!!");
    }
    return false;
    }
}
