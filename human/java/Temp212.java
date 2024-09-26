public class Temp212 {
    public static void main(String[] args) {
        MyUserDAO myUserDAO = new MyUserDAO();
        Principal principal = new Principal("exampleUsername");
        MyUser loggedInUser = myUserDAO.getByUsername(principal.getName());
        MyUserDetails loggedInUserUD = new MyUserDetails(loggedInUser);
        if (loggedInUserUD.hasAnyPermission("perm1, perm2")) {
            // do stuff
            System.out.println("User has the required permissions.");
        } else {
            System.out.println("User does not have the required permissions.");
        }
    }
}

class MyUser {
    private String username;

    public MyUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

class MyUserDAO {
    public MyUser getByUsername(String username) {
        // Mock implementation for demonstration
        return new MyUser(username);
    }
}

class MyUserDetails {
    private MyUser user;

    public MyUserDetails(MyUser user) {
        this.user = user;
    }

    public boolean hasAnyPermission(String permissions) {
        // Mock implementation for demonstration
        String[] perms = permissions.split(", ");
        for (String perm : perms) {
            if ("perm1".equals(perm) || "perm2".equals(perm)) {
                return true;
            }
        }
        return false;
    }
}

class Principal {
    private String name;

    public Principal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}