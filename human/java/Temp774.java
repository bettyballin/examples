import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class Temp774 {
    public static void main(String[] args) {
        Temp774 temp = new Temp774();
        temp.saveFile("path/to/directory", "filename");
    }

    public void saveFile(String filepath, String filename) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() {
            public Object run() {
                File theDir = new File(filepath);
                try {
                    if (theDir.exists()) {
                        System.out.println("Directory Exists");
                    } else {
                        System.out.println("Creating Directory...");
                        if (theDir.mkdir()) {
                            System.out.println("Directory Created");
                        } else {
                            System.out.println("Directory Creation Failed!");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error Reading Directory!");
                    System.out.println(filepath);
                }
                return null;
            }
        });
    }
}