import java.util.HashMap;
import java.util.Map;

public class DataStore {

    // constructore of class

    private static DataStore instance = new DataStore();

    // map of username and password using hashes
    private Map<String, Integer> user_map = new HashMap<String, Integer>();

    public DataStore() {
    }

    public static DataStore getInstance(){
        return instance;
    }

    public boolean is_UsernameTaken(String username){
        return user_map.containsKey(username);
    }

    public void register_User(String username, String password){
        int passwordHash = password.hashCode();
        user_map.put(username, passwordHash);
    }

    public boolean isLogin_Correct(String username, String password) {

        //user name doesnot exist
        if(!user_map.containsKey(username)){
            return false;
        }

        int passwordHash = password.hashCode();
        int storedPasswordHash = user_map.get(username);

        return passwordHash == storedPasswordHash;
    }
}
