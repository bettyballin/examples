import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Temp2616 {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("openssl enc -base64 -A -d -in signature.txt -out signatureToVerify.bin");
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