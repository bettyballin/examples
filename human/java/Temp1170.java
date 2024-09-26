import java.io.Closeable;

public class Temp1170 {
    public static void main(String[] args) {
        Closeable input = null;
        Closeable output = null;
        
        try {
            // Initialize input and output with actual resources
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (output != null) {
                try {
                    output.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}