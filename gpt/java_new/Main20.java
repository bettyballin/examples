import java.security.Permission;
import java.net.SocketPermission;

public class Main20 {
    public static void main(String[] args) {
        Permission permission = new SocketPermission("smtp.example.com:25", "connect,resolve");
        // Use the permission object as needed for your security context
    }
}