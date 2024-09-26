import java.io.FilePermission;
import java.security.Permission;

public class Temp937 {
    public static void main(String[] args) {
        Permission permission = new FilePermission(System.getProperty("user.home") + "/AppData/Local/NetBeans/-", "write");
        System.out.println("Permission granted: " + permission);
    }
}