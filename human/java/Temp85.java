import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class Temp85 {
    public static void main(String[] args) {
        File myFile = (File) AccessController.doPrivileged(new PrivilegedAction<File>() {
            public File run() {
                return new File("C:\\MyFolder\\MyFile");
            }
        });

        System.out.println("File path: " + myFile.getPath());
    }
}