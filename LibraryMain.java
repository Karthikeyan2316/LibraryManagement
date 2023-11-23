package LibraryManagment;
import java.util.Date;
import java.net.UnknownServiceException;
import java.sql.*;
import java.util.*;
public class LibraryMain {
  public static void main(String[] args) throws SQLException {
    Scanner sc=new Scanner(System.in);
    boolean SystemOn=true;
    while(SystemOn)
    {
        System.out.println("--------------------------------------Welcome to Library!!!-----------------------------------------");
        System.out.println("Please enter your userName and Password");
        String UserName=sc.nextLine();
        String Password=sc.nextLine();
        UsersDAO userDao=new UsersDAO();
        boolean isAvailable =userDao.checkPassword(UserName,Password);
        Users currentUser=new Users();
        currentUser=userDao.returnUser(UserName,Password);
        if(isAvailable==true)
        {
            System.out.println("Showing all the available books in library");
            BooksDAO bookdao=new BooksDAO();
            ResultSet rs=bookdao.displayAvailableBooks();
            while(rs.next())
            {
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
                System.out.println();
            }
            System.out.println("which book do you want??, kindly enter the book id and enter the number of copies");
            int bookdId=sc.nextInt();
            int copies=sc.nextInt();
            Books book=new Books();
            book=bookdao.mapBooks(bookdId);
           boolean available= bookdao.bookMinus(bookdId, copies, currentUser);
           if(available==true)
           {
            TransactionDAO transdao=new TransactionDAO();
            transdao.addTransaction(currentUser,bookdId,copies);
            System.out.println("----------------------------------------------------------------");
            System.out.println("-------------------------THANK YOU!!!!--------------------------");
            System.out.println("----------------------------------------------------------------");
            System.out.println("Enter 1 to keep on  and 0 to turn off");
            int num=sc.nextInt();
            if(num==0)
            {
                break;
            }
        }
        else{
            System.out.println("Currently we dont have that much amount of copies..Extremely sorry!!!");
            continue;
        }
        }

        else{
            continue;
            }


    }
  }
}
