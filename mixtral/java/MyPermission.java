import java.security.BasicPermission;
import java.security.Permission;

public class MyPermission extends BasicPermission {
    public MyPermission(String name, String actions) {
        super(name);
    }

    public MyPermission(String name) {
        super(name);
    }

    public static void main(String[] args) {
        // Define the necessary permissions
        Permission myPermission = new MyPermission("my.permission", "action");
        System.out.println("Permission created: " + myPermission.getName());
    }
}