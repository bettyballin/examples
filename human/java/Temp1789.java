public class Temp1789 {
    public static void main(String[] args) {
        SecurityHelper.setupSecurityContext("user", "password", "g1", "g2");
    }
}

class SecurityHelper {
    public static void setupSecurityContext(String user, String password, String... groups) {
        System.out.println("User: " + user);
        System.out.println("Password: " + password);
        System.out.print("Groups: ");
        for (String group : groups) {
            System.out.print(group + " ");
        }
    }
}