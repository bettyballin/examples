import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class Temp2149 {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        PublicKey publicKey = pair.getPublic();
        PrivateKey privateKey = pair.getPrivate();

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        String input = "Hello, World!";
        
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherBytes = cipher.doFinal(input.getBytes());
        System.out.println("cipher: " + new String(cipherBytes));
        String returnValue = new String(cipherBytes);

        String cipherText = Base64.getEncoder().encodeToString(cipherBytes);
        byte[] reCipherBytes = Base64.getDecoder().decode(cipherText);

        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] plainText = cipher.doFinal(reCipherBytes);
        System.out.println("plain : " + new String(plainText));
    }
}