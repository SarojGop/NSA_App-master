import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class Myobserver extends Observable {

    private List<Observer> lobservers = new ArrayList<Observer>();
    private String email, fullname, password;
    private long mobile;


    public void changeemail(String newemail) {
        this.email = newemail;
        setChanged();
        notifyObservers(email);
    }
    public void changefullname(String name) {
        this.fullname= name;
        setChanged();
        notifyObservers(fullname);
    }
    public void changephone(long phone) {
        this.mobile = (Long.parseLong(String.valueOf(phone)));
        setChanged();
        notifyObservers(mobile);
    }
    public void addnew(Observer observer){
        lobservers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : lobservers) {
            observer.update((Observable) observer, email);
            observer.update((Observable) observer, mobile);
            observer.update((Observable) observer, fullname);
        }
    }
}


