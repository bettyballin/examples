import java.io.File;
import java.io.IOException;

public class Temp96 {
    public static void main(String[] args) {
        File myExternalFile = new File("myfile.txt");
        if (myExternalFile.exists()) {
            try {
                if (myExternalFile.setReadable(false)) {
                    System.out.println("File permission changed to non-readable.");
                } else {
                    System.out.println("Failed to change file permission.");
                }
            } catch (SecurityException e) {
                System.out.println("Security exception: " + e.getMessage());
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
}