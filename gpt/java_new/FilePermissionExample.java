import java.io.FilePermission;
import java.security.Permission;

public class FilePermissionExample {
    public static void main(String[] args) {
        String userHome = System.getProperty("user.home");
        String fileSeparator = System.getProperty("file.separator");
        String path = userHome + fileSeparator + "AppData" + fileSeparator + "Local" + fileSeparator + 
                      "NetBeans" + fileSeparator + "Cache" + fileSeparator + "7.4" + fileSeparator + "-";
        
        Permission permission = new FilePermission(path, "read,write");
        
        // Note: Additional code to use the permission object would go here.
    }
}