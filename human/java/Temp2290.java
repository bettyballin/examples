import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Temp2290 {
    public static void main(String[] args) {
        try {
            // Run openssl pkcs12 command
            Process process1 = Runtime.getRuntime().exec(
                "openssl pkcs12 -in \"C:\\Program Files\\Java\\jdk1.8.0_131\\jre\\lib\\security\\file.pfx\" " +
                "-out \"C:\\Program Files\\Java\\jdk1.8.0_131\\jre\\lib\\security\\tempcertfile.crt\" -nodes");
            printProcessOutput(process1);

            // Run openssl x509 command
            Process process2 = Runtime.getRuntime().exec(
                "openssl x509 -outform der -in \"C:\\Program Files\\Java\\jdk1.8.0_131\\jre\\lib\\security\\file.pem\" " +
                "-out \"C:\\Program Files\\Java\\jdk1.8.0_131\\jre\\lib\\security\\file.der\"");
            printProcessOutput(process2);

            // Run java command to import private key
            Process process3 = Runtime.getRuntime().exec(
                "java -cp C:\\Oracle\\Middleware\\Oracle_Home\\wlserver\\server\\lib\\weblogic.jar utils.ImportPrivateKey " +
                "-keystore \"C:\\Program Files\\Java\\jdk1.8.0_131\\jre\\lib\\security\\file.jks\" " +
                "-storepass mypass -storetype JKS -keypass mypass -alias myalias " +
                "-certfile \"C:\\Program Files\\Java\\jdk1.8.0_131\\jre\\lib\\security\\file.pem\" " +
                "-keyfile \"C:\\Program Files\\Java\\jdk1.8.0_131\\jre\\lib\\security\\file.key\" " +
                "-keyfilepass mypass");
            printProcessOutput(process3);

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
        reader.close();
    }
}