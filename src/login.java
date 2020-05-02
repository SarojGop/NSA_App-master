import java.util.Scanner;
public class login extends DataStore {


    String username, password;
    Scanner Input = new Scanner(System.in);

//constructor
    public login() {
        super();
        this.username = this.getUsername();
        this.password = this.getPassword();

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //get password
    public String getPassword() {
        return password;
    }

    //set Password
    public void setPassword(String password) {
        this.password = password;
    }
    ///replaceAll("\\s", "");//discard whitespace
    // sign up for new user
    public void sign_Up() {
        String username1, password1;
        System.out.println("Enter a Username :\n");
        username1 =Input.nextLine(); //getInput for username
        System.out.println("\nEnter a Password atleast 8 character\n");
        password1 = Input.nextLine(); // getInput for password

        this.setPassword(username1);
        this.setPassword(password1);
        /* check username for empty */
        if (this.getUsername().isEmpty()) {
            System.out.println( "\n" + "Enter a Username again");
            username =Input.nextLine();
            this.setPassword(username1);
        } else if (this.getPassword().isEmpty()) {
            System.out.println("\n" + "The password must be grater then 8 character"+"\n"+"Enter a password Again!!");
            password = Input.nextLine(); // getInput for password
            this.setPassword(password1);
        } else if(super.is_UsernameTaken (this.getUsername ())) {
            this.setUsername(username1);
            this.setPassword(password1);
            super.register_User (this.getUsername (),this.getPassword ());
            super.isLogin_Correct (this.getUsername (),this.getPassword ());
            System.out.println ("Successfully Sign Up ");

        }
        //store class for filebase data base
    }


    // sigIn and check if user name and password is correct
    public void sign_In(String getUsername, String getPassword) {

       //working with firebase to get data
    }

}

