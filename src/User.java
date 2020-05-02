public class User extends Myobserver {
    private String email;
    private String password;
    private String Fullname;
    private long mobile;
    Myobserver implementobserver = new Myobserver();
    public User(){
        super();
        implementobserver.changeemail(email);
        implementobserver.changefullname(Fullname);
        implementobserver.changephone(mobile);
        this.password="Unknown";
        this.password ="Unknow";
        this.Repeat_Password ="Unkown";
    }

    public User(String email, String password, String repeat_Password, String fullname, long mobile) {
        this.email = email;
        this.password = password;
        Repeat_Password = repeat_Password;
        Fullname = fullname;
        this.mobile = mobile;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeat_Password() {
        return Repeat_Password;
    }

    public void setRepeat_Password(String repeat_Password) {
        Repeat_Password = repeat_Password;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = (Long.parseLong(mobile));
    }

    private String Repeat_Password;


}
