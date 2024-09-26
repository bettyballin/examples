import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp2641 {
    public static void main(String[] args) {
        try {
            String[] command = {"/bin/sh", "-c", "codesign -s \"P6DMU6694X\" -v dependency.dylib"};
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}