import java.io.FileOutputStream;
import java.io.IOException;

public class Temp515 {
    public static void main(String[] args) {
        byte[] realSig = {1, 2, 3, 4, 5}; // Example byte array

        try (FileOutputStream outStream = new FileOutputStream("signature")) {
            outStream.write(realSig);
            outStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}