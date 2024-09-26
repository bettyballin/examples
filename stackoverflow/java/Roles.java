import java.util.List;
import java.util.ArrayList;

public class Roles {

    public static List<String> all() {
        return List.of("admin", "hr", "developer", "accountant", "devops");
    }

    public static List<String> exclude(String excludeRole) {
        List<String> result = new ArrayList<>(all());
        result.remove(excludeRole);
        return result;
    }
}