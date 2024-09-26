import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Temp2925 {
    public static void main(String[] args) {
        String filePath = "path/to/your/file";
        byte[] filebytea = new byte[1024]; // Adjust the size as needed

        try (DataInputStream in = new DataInputStream(new FileInputStream(filePath))) {
            in.readFully(filebytea); 
        } catch (IOException e) {
            System.out.println("error in file stream: " + e.getMessage());
        }
    }
}