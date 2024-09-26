public class Temp163 {

    public static void main(String[] args) {
        User user = new User("John Doe");
        PrivilegeType privilege = PrivilegeType.ADMIN;

        boolean authorized = isAuthorized(user, privilege);
        System.out.println("Is user authorized: " + authorized);
    }

    public static boolean isAuthorized(User user, PrivilegeType privilege) {
        // Example logic for authorization
        if (user.getName().equals("John Doe") && privilege == PrivilegeType.ADMIN) {
            return true;
        }
        return false;
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

enum PrivilegeType {
    ADMIN,
    USER,
    GUEST
}