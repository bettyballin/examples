import java.io.FilePermission;

public class Temp57 {
    public static void main(String[] args) {
        FilePermission perm = new FilePermission("test.txt", "read");
        
        if (perm instanceof FilePermission) {
            if (perm.getActions().equals("read")) {
                // grant permission
                System.out.println("Permission granted");
                return;
            }
        }
        
        System.out.println("Permission not granted");
    }
}