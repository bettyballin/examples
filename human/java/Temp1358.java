import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Temp1358 {
    public static void main(String[] args) {
        try {
            // Generate key
            Process keygen = new ProcessBuilder("keytool", "-genkey", "-keyalg", "rsa", "-alias", "m4key").start();
            printProcessOutput(keygen);

            // Export certificate
            Process exportCert = new ProcessBuilder("keytool", "-export", "-alias", "m4key", "-file", "bmcert.crt").start();
            printProcessOutput(exportCert);

            // List contents of the JAR file
            Process listJar = new ProcessBuilder("jar", "tvf", "Jarname.jar").start();
            printProcessOutput(listJar);

            // Sign the JAR file
            Process signJar = new ProcessBuilder("jarsigner", "Jarname.jar", "m4key").start();
            printProcessOutput(signJar);

            // Verify the JAR file
            Process verifyJar = new ProcessBuilder("jarsigner", "-verify", "-verbose", "-certs", "Jarname.jar").start();
            printProcessOutput(verifyJar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printProcessOutput(Process process) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}