import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;

public class Temp1216 {
    public static void main(String[] args) {
        try {
            // Generate a key pair for demonstration purposes
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair pair = keyGen.generateKeyPair();
            PrivateKey key = pair.getPrivate();

            byte[] enc_key = key.getEncoded();

            // Byte array to string
            StringBuilder key_builder = new StringBuilder();

            for(byte b : enc_key){
                key_builder.append(String.format("%02x", b));
            }

            String serialized_key = key_builder.toString();
            System.out.println(serialized_key);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}