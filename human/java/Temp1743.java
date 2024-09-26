import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp1743 {
    public static void main(String[] args) {
        try {
            String[] command = {
                "keytool", 
                "-importkeystore", 
                "-srckeystore", "myKeystore.jks", 
                "-destkeystore", "myKeystore.p12", 
                "-deststoretype", "PKCS12", 
                "-srcalias", "someAlias", 
                "-srcstorepass", "12345678", 
                "-deststorepass", "1122334455", 
                "-destkeypass", "1122334455"
            };

            Process process = new ProcessBuilder(command).start();
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