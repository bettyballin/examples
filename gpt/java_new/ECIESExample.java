import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.security.spec.*;

public class ECIESExample {

    public static byte[] encrypt(PublicKey publicKey, byte[] plaintext) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("ECIES");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(plaintext);
    }

    public static byte[] decrypt(PrivateKey privateKey, byte[] ciphertext) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("ECIES");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(ciphertext);
    }

    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
            kpg.initialize(new ECGenParameterSpec("secp256r1"));
            KeyPair keyPair = kpg.generateKeyPair();

            String message = "This is a secret message!";
            byte[] plaintext = message.getBytes();

            byte[] encryptedText = encrypt(keyPair.getPublic(), plaintext);
            byte[] decryptedText = decrypt(keyPair.getPrivate(), encryptedText);

            System.out.println("Original: " + message);
            System.out.println("Encrypted: " + new String(encryptedText));
            System.out.println("Decrypted: " + new String(decryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}