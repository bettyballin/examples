import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.FixedByteArrayIVGenerator;
import java.nio.charset.StandardCharsets;

public class Temp1417 {
    public static void main(String[] args) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("something"); // your seed

        // Disable random salt generation
        byte[] fixedSalt = "fixedsalt".getBytes(StandardCharsets.UTF_8);
        encryptor.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        encryptor.setIvGenerator(new FixedByteArrayIVGenerator(fixedSalt));

        String ep = encryptor.encrypt("mypasswordtext");

        System.out.println("Encrypted Text: " + ep);
    }
}