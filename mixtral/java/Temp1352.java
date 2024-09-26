import java.io.FilePermission;
import java.security.Permission;

class MySecurityManager extends SecurityManager {
    @Override
    public void checkExit(int status) {
        throw new SecurityException();
    }

    @Override
    public void checkRead(String file) {}

    @Override
    public void checkPermission(Permission perm) {
        if (perm instanceof FilePermission && ((FilePermission) perm).getActions().contains("read")) {
            return;
        }
        super.checkPermission(perm);
    }

    public static void main(String[] args) {
        System.setSecurityManager(new MySecurityManager());
        try {
            System.exit(0);
        } catch (SecurityException se) {
            System.out.println("Exit attempt blocked by security manager");
        }

        try {
            java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("test.txt"));
            System.out.println("File read allowed");
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}