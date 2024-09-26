import java.io.FileDescriptor;
import java.lang.SecurityException;
import java.lang.SecurityManager;

public class MySecurityManager extends SecurityManager {

    @Override
    public void checkRead(FileDescriptor fd) {
        // Allow or deny read operations based on your criteria
        System.out.println("Checking read access to: " + fd);
    }

    @Override
    public void checkWrite(String file) {
        // Deny write operation for uploaded classes
        System.out.println("Checking write access to: " + file);
        if (file.endsWith(".class")) {
            throw new SecurityException("Writing to .class files is denied");
        }
    }

    public static void main(String[] args) {
        MySecurityManager mySecurityManager = new MySecurityManager();
        System.setSecurityManager(mySecurityManager);

        try {
            FileDescriptor fd = FileDescriptor.in;
            mySecurityManager.checkRead(fd);

            String fileName = "example.class";
            mySecurityManager.checkWrite(fileName);
        } catch (SecurityException e) {
            System.out.println("SecurityException: " + e.getMessage());
        }
    }
}