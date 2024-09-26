import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp1540 {
    public static void main(String[] args) {
        String[] command = {
            "jarsigner",
            "-tsa", "http://timestamp.digicert.com",
            "-keystore", "NONE",
            "-storetype", "PKCS11",
            "-providerClass", "sun.security.pkcs11.SunPKCS11",
            "-providerArg", "card_linux.config",
            "-storepass", getStorePass(),
            "-sigalg", "SHA256withRSA",
            "dist/sup2rtam.jar",
            "Identity #0"
        };

        try {
            Process process = new ProcessBuilder(command).start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getStorePass() {
        StringBuilder storePass = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Runtime.getRuntime().exec("cat ~/cardpass").getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                storePass.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return storePass.toString();
    }
}