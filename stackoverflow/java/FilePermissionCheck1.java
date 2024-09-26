import java.io.FilePermission;
import java.security.AccessController;

public class FilePermissionCheck1 {
    public static void main(String[] args) {
        FilePermission perm = new FilePermission("path/file", "read");
        AccessController.checkPermission(perm);
    }
}