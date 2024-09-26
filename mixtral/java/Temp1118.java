import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;

public class Temp1118 {
    public static void main(String[] args) {
        try {
            byte[] desKey = javax.xml.bind.DatatypeConverter.parseHexBinary("your_key");

            SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");

            DESedeKeySpec spec = new DESedeKeySpec(desKey);

            Key secretKey = factory.generateSecret(spec);

            System.out.println("Key generated successfully: " + secretKey);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException | javax.crypto.SecretKeyException e) {
            e.printStackTrace();
        }
    }
}