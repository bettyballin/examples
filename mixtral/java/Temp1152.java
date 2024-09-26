import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class Temp1152 {
    public static void main(String[] args) {
        Reader reader = null;
        try {
            // Your code here
            reader = new StringReader("Sample text");
            int data = reader.read();
            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }
        } catch (Exception e) {
            if (e != null)
                System.err.println("Caught Exception:" + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    // handle close exception
                    System.err.println("Failed to close reader: " + ex.getMessage());
                }
            }
        }
    }
}