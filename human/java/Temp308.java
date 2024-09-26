import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp308 {
    public static void main(String[] args) {
        try {
            String[] command = {
                "/bin/bash",
                "-c",
                "key128=\"01020304050607080900010203040506\"; " +
                "iv=\"01020304050607080900010203040506\"; " +
                "openssl enc -aes-128-cbc -in test -out test.enc -K $key128 -iv $iv"
            };
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}