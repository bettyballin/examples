import java.net.SocketPermission;
import java.security.Permission;
import java.security.Permissions;

public class Temp2533 {
    public static void main(String[] args) {
        Permissions permissions = new Permissions();
        Permission socketPermission = new SocketPermission("*", "connect,resolve");
        permissions.add(socketPermission);

        // Checking the permission added
        if (permissions.implies(socketPermission)) {
            System.out.println("Socket permission granted.");
        } else {
            System.out.println("Socket permission not granted.");
        }
    }
}