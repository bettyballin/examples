import java.net.SocketPermission;
import java.security.Permission;

public class Main49 {
    public static void main(String[] args) {
        Permission permission = new SocketPermission("*.salesforce.com:443", "connect,resolve");
        // Now you can use the 'permission' variable as needed in your code
    }
}