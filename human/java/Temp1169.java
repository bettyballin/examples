import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Temp1169 {
    public static void main(String[] args) {
        try {
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("dest.txt"));
            // You can now use 'output' to write data to the file
            output.write("Hello, World!".getBytes());
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}