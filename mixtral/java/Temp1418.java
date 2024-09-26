import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.FixedByteArrayIVGenerator;
import java.nio.charset.StandardCharsets;

public class Temp1418 {
    public static void main(String[] args) {
        // Example encrypted password (for demonstration purposes)
        String ep = "your-encrypted-password-here";

        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        decryptor.setPassword("something"); // your seed

        // Use fixed salt
        byte[] fixedSalt = "fixedsalt".getBytes(StandardCharsets.UTF_8);
        decryptor.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        decryptor.setIvGenerator(new FixedByteArrayIVGenerator(fixedSalt));

        String decryptedPassword = decryptor.decrypt(ep);
        System.out.println("Decrypted Password: " + decryptedPassword);
    }
}