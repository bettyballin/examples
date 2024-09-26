import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Arrays;

public class Temp449 {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey k = keyGen.generateKey();
        
        byte[] ivBytes = new byte[16];
        IvParameterSpec iv = new IvParameterSpec(ivBytes);
        
        String textData = "This is some text data to encrypt";
        byte[] textDataBytes = textData.getBytes();
        
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, k, iv);
        byte[] someData = c.update(textDataBytes);
        byte[] moreData = c.doFinal();
        
        System.out.println("E: " + (someData.length + moreData.length));
        
        c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, k, iv);
        byte[] someDecrypted = c.update(someData);
        byte[] moreDecrypted = c.doFinal(moreData);
        
        System.out.println("R: " + (someDecrypted.length + moreDecrypted.length));
        System.out.println("Decrypted text: " + new String(someDecrypted) + new String(moreDecrypted));
    }
}