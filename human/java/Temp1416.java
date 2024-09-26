import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp1416 {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"sh", "-c", "echo '539B333B39706D149028CFE1D9D4A407' | xxd -r -p"});
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}