package LibraryManagment;
public class Users {
    int id;
    String name;
    String Role;
    String UserName;
    String Password;
    Users(int id,String name,String role,String pass,String UserName)
    {
        this.id=id;
        this.name=name;
        this.Role=role;
        this.Password=pass;
        this.UserName=UserName;
    }
    Users()
    {  
    }
}
