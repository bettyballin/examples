import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Temp699 {
    public static void main(String[] args) {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey key = keyGen.generateKey();
            
            String hexStr = javax.xml.bind.DatatypeConverter.printHexBinary(key.getEncoded()).toLowerCase();
            System.out.println(hexStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}