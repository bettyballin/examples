import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Temp1394 {
    public static void main(String[] args) {
        String filePath = "yourfile.txt"; // Replace with your file path
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // search for '.dex'
                if (line.contains(".dex")) {
                    // get starting and ending addresses of the DEX file region
                    System.out.println("Found .dex in line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}