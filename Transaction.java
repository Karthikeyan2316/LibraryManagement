package LibraryManagment;
import java.util.Date;
public class Transaction {
    static int transactionId=1;
    Books bookName;
    Users Member;
    Date issueDate;
    Date returnDate;
    Transaction(Books book,Users user,Date DOI)
    {
        this.bookName=book;
        this.Member=user;
        this.issueDate=DOI;
        this.returnDate=null;
        transactionId++;
    }

}
//for Admin purpose only this DAOclass !!!