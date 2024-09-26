class UserDetails {
    private String username;

    public UserDetails(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

class UsernameNotFoundException extends Exception {
    public UsernameNotFoundException(String message) {
        super(message);
    }
}

class DataAccessException extends Exception {
    public DataAccessException(String message) {
        super(message);
    }
}

class MyUserService {
    public UserDetails getMyUser(String username) {
        // Simulate a user lookup
        if ("testUser".equals(username)) {
            return new UserDetails(username);
        }
        return null;
    }
}

public class Temp277 {
    private MyUserService myUserService = new MyUserService();

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        UserDetails user = myUserService.getMyUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return user;
    }

    public static void main(String[] args) {
        Temp277 temp = new Temp277();
        try {
            UserDetails user = temp.loadUserByUsername("testUser");
            System.out.println("User found: " + user.getUsername());
        } catch (UsernameNotFoundException | DataAccessException e) {
            e.printStackTrace();
        }
    }
}