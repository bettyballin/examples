import java.io.File;
import java.io.IOException;

public class Temp855 {
    public static void main(String[] args) {
        try {
            String userInput = ".../malware";
            File file = new File(userInput);
            if (file.getCanonicalPath().startsWith("/var/www/html/img")) {
                // process the image
                System.out.println("Processing the image...");
            } else {
                throw new SecurityException("Invalid path");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}