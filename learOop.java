package konstruktor; //nama 

//Belajar OOP Constructor
public class User {
    
    //Deklarasi Variable
    public String username;
    public String password;
    
    
    public User(String username, String password){ //Nama Constructor
        this.username = username;
        this.password = password;
    }
       
}


class DemoConstructor{
    public static void main(String[] args) {
        User imam = new User("Babyface", "Privacy2Politicts");
        System.out.println("Username: " + imam.username);
        System.out.println("Password: " + imam.password);
    }
}

