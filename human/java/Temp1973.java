import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp1973 {
    public static void main(String[] args) {
        try {
            // Command 1
            ProcessBuilder processBuilder1 = new ProcessBuilder(
                "keytool", "-importkeystore",
                "-deststorepass", "changeit",
                "-destkeypass", "changeit",
                "-destkeystore", "keystore.jks",
                "-srckeystore", "myOwnCert.p12",
                "-srcstoretype", "PKCS12",
                "-srcstorepass", "changeit",
                "-alias", "myOwnAlias"
            );
            Process process1 = processBuilder1.start();
            printProcessOutput(process1);
            
            // Command 2
            ProcessBuilder processBuilder2 = new ProcessBuilder(
                "keytool", "-importkeystore",
                "-deststorepass", "changeit",
                "-destkeypass", "changeit",
                "-destkeystore", "cacerts.jks",
                "-srckeystore", "myOwnCert.p12",
                "-srcstoretype", "PKCS12",
                "-srcstorepass", "changeit",
                "-alias", "myOwnAlias"
            );
            Process process2 = processBuilder2.start();
            printProcessOutput(process2);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printProcessOutput(Process process) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}