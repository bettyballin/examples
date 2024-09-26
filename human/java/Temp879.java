import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Temp879 {
    public static void main(String[] args) {
        String dc = "xxxx";
        String objectClass = "yyyyy";
        String certificatePath = "/path/to/certificate.der";

        try {
            byte[] certificateBytes = Files.readAllBytes(Paths.get(certificatePath));
            String certificateBase64 = Base64.getEncoder().encodeToString(certificateBytes);

            System.out.println("dc: " + dc);
            System.out.println("objectClass: " + objectClass);
            System.out.println("userCertificate;binary:< " + certificateBase64);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}