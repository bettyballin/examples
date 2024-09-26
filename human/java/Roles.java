import java.util.ArrayList;
import java.util.List;

public class Roles {

    public static List<String> all() {
        return List.of("admin", "hr", "developer", "accountant", "devops");
    }

    public static List<String> exclude(String excludeRole) {
        List<String> result = new ArrayList<>(all());
        result.remove(excludeRole);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("All roles: " + all());
        System.out.println("Roles excluding 'developer': " + exclude("developer"));
    }
}