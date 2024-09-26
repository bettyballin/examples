import java.io.FileOutputStream;
import java.io.IOException;

public class Temp95 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("myfile.txt")) {
            String encryptedData = "sample data"; // Add some sample data to write
            fos.write(encryptedData.getBytes());
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}