import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Temp2113 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("fileData.txt"))) {
            char[] data = null;
            try {
                int ch;
                while ((ch = br.read()) != -1) {
                    System.out.print((char) ch);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (data != null) {
                    Arrays.fill(data, '\0');
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}