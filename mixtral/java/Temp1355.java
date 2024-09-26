import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Temp1355 {
    public static void main(String[] args) {
        String fileName = "example.dat"; // Replace this with your actual file name

        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            // Your deserialization code here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}