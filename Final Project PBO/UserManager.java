import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, RegularUser> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public boolean registerUser(String username, int age, double height, double weight, String gender) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }
        RegularUser newUser = new RegularUser(username, age, height, weight, gender);
        users.put(username, newUser);
        return true;
    }

    public RegularUser loginUser(String username) {
        return users.get(username);
    }
}
