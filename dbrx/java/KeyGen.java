import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class KeyGen {
    public static void main(String[] args) throws Exception {
        String inputData = "your_data_here";
        char[] password = "password".toCharArray();

        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[8];
        random.nextBytes(salt);

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048); // 2048 bits recommended

        keyGen.generateKeyPair();
        KeyPair pair = keyGen.generateKeyPair();
        System.out.println("Public Key: " + pair.getPublic());
        System.out.println("Private Key: " + pair.getPrivate());

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        PBEKeySpec spec = new PBEKeySpec(password, salt, 10000, 256);
        factory.generateSecret(spec);
    }
}