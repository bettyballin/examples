import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class Main7 {
    public static void main(String[] args) {
        File myFile = AccessController.doPrivileged(new PrivilegedAction<File>() {
            public File run() {
                return new File("C:\\MyFolder\\MyFile");
            }
        });
    }
}