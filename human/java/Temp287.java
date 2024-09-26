import java.util.HashMap;
import java.util.Map;

public class Temp287 {
    public static void main(String[] args) {
        Map<String, String> errorPagesByRoles = new HashMap<>();
        errorPagesByRoles.put("ROLE_AAA", "/errorpageaaa.jsp");
        errorPagesByRoles.put("ROLE_BBB", "/errorpagebbb.jsp");

        // Print the error pages by roles to verify
        for (Map.Entry<String, String> entry : errorPagesByRoles.entrySet()) {
            System.out.println("Role: " + entry.getKey() + ", Error Page: " + entry.getValue());
        }
    }
}