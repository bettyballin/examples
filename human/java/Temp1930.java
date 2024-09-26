import java.io.BufferedInputStream;
import java.io.InputStream;

public class Temp1930 {
    public static void main(String[] args) {
        // Since we don't have the Android context, simulate the InputStream
        InputStream caInput = new BufferedInputStream(System.in);
        
        // Example usage to read some data from InputStream (just for demonstration)
        try {
            int data = caInput.read();
            while (data != -1) {
                System.out.print((char) data);
                data = caInput.read();
            }
            caInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}