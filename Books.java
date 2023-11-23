package LibraryManagment;
public class Books {
    int bookId;
    String bookName;
    String Author;
    int copies;
    Books(int id,String Bname,String Author,int copies)
    {
        this.bookId=id;
        this.bookName=Bname;
        this.Author=Author;
        this.copies=copies;
    }
    Books()
    {}
 
}
