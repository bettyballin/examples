import java.security.*;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.*;
import javax.crypto.spec.*;

public class EncryptionDecryption {

    private static final int iterations = 65536;
    private static final int keySize = 256;
    private static final SecureRandom secureRandom = new SecureRandom();

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        byte[] salt = getSalt();

        System.out.print("Enter message: ");
        String message = in.nextLine();

        System.out.print("Enter password: ");
        String password = in.nextLine();

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keySize);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secret);
        AlgorithmParameters params = cipher.getParameters();
        byte[] iv = params.getParameterSpec(IvParameterSpec.class).getIV();
        byte[] ciphertext = cipher.doFinal(message.getBytes("UTF-8"));

        System.out.println("Ciphertext: " + Base64.getEncoder().encodeToString(ciphertext));
        System.out.println("IV: " + Base64.getEncoder().encodeToString(iv));

        cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
        String plaintext = new String(cipher.doFinal(ciphertext), "UTF-8");
        System.out.println("Plaintext: " + plaintext);
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException {
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;
    }
}