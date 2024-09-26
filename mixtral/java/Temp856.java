import java.io.File;
import java.io.IOException;

public class Temp856 {
    public static void main(String[] args) {
        try {
            String userInput = "../../../etc/malware";
            File file = new File(userInput);
            if (file.getCanonicalPath().startsWith("/var/www/html/img")) {
                // process the image
                System.out.println("Valid path, processing image...");
            } else {
                throw new SecurityException("Invalid path");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}