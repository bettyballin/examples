import java.io.IOException;
import java.io.RandomAccessFile;

public class Temp1023 {
    public static void main(String[] args) {

        try (RandomAccessFile fileStore = new RandomAccessFile("inputFile", "rw")) {
            // Your code here
        } catch (IOException ex) {
            throw new RuntimeException("Error while processing the input/output files", ex);
        }

    }
}