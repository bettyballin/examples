import java.util.List;
import java.util.ArrayList;

public class Temp74 {

    // Assuming there's a UserRoleService class with a getGroups method
    private static UserRoleService userRoleService = new UserRoleService();

    public static void main(String[] args) {
        Temp74 temp = new Temp74();
        List<String> permissions = temp.getPermissions("exampleUsername");
        for (String permission : permissions) {
            System.out.println(permission);
        }
    }

    public List<String> getPermissions(String username) {
        String dn = retrieveDN(username); // Mock implementation to retrieve DN
        return userRoleService.getGroups(dn);
    }

    private String retrieveDN(String username) {
        // Mock implementation to retrieve DN for a given username
        return "cn=" + username + ",ou=users,dc=example,dc=com";
    }
}

// Mock UserRoleService class
class UserRoleService {
    public List<String> getGroups(String dn) {
        // Mock implementation
        List<String> groups = new ArrayList<>();
        groups.add("Admin");
        groups.add("User");
        return groups;
    }
}