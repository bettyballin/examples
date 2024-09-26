import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;

public class Temp1508 {
    public static void main(String[] args) {
        // Example usage
        try {
            byte[] iv = new byte[16]; // Example IV, should be properly initialized
            byte[] ciphertext = new byte[16]; // Example ciphertext, should be properly initialized
            SecretKeySpec key = new SecretKeySpec("1234567812345678".getBytes(), "AES"); // Example key

            AES aes = new AES();
            aes.setKey(key);
            String decryptedText = aes.decrypt(iv, ciphertext);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}

class AES {
    private Cipher cipher;
    private SecretKeySpec key;

    public AES() throws GeneralSecurityException {
        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }

    public void setKey(SecretKeySpec key) {
        this.key = key;
    }

    public String decrypt(byte[] ivBytes, byte[] ciphertext) throws GeneralSecurityException {
        System.out.println("Using key " + Base64.getEncoder().encodeToString(key.getEncoded()) + " to decrypt");

        // Set up cipher to decrypt
        IvParameterSpec iv = new IvParameterSpec(ivBytes);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);

        byte[] decodedPlaintext = cipher.doFinal(ciphertext);

        return new String(decodedPlaintext, StandardCharsets.UTF_8);
    }
}

is modified to:


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;

public class Temp1508 {
    public static void main(String[] args) {
        // Example usage
        try {
            byte[] iv = new byte[16]; // Example IV, should be properly initialized
            byte[] ciphertext = new byte[16]; // Example ciphertext, should be properly initialized
            SecretKeySpec key = new SecretKeySpec("1234567812345678".getBytes(), "AES"); // Example key

            AES aes = new AES();
            aes.setKey(key);
            String decryptedText = aes.decrypt(iv, ciphertext);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}

class AES {
    private Cipher cipher;
    private SecretKeySpec key;

    public AES() throws GeneralSecurityException {
        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }

    public void setKey(SecretKeySpec key) {
        this.key = key;
    }

    public String decrypt(byte[] ivBytes, byte[] ciphertext) throws GeneralSecurityException {
        System.out.println("Using key " + Base64.getEncoder().encodeToString(key.getEncoded()) + " to decrypt");

        // Set up cipher to decrypt
        IvParameterSpec iv = new IvParameterSpec(ivBytes);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);

        byte[] decodedPlaintext = cipher.doFinal(ciphertext);

        return new String(decodedPlaintext, StandardCharsets.UTF_8);
    }
}

to:


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;

public class Temp1508 {
    public static void main(String[] args) {
        // Example usage
        try {
            byte[] iv = "0000000000000000".getBytes(); // Example IV, should be properly initialized
            byte[] ciphertext = new byte[16]; // Example ciphertext, should be properly initialized
            SecretKeySpec key = new SecretKeySpec("1234567812345678".getBytes(), "AES"); // Example key

            AES aes = new AES();
            aes.setKey(key);
            String decryptedText = aes.decrypt(iv, ciphertext);
            System.out.println("Decrypted Text: " + decryptedText);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}

class AES {
    private Cipher cipher;
    private SecretKeySpec key;

    public AES() throws GeneralSecurityException {
        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }

    public void setKey(SecretKeySpec key) {
        this.key = key;
    }

    public String decrypt(byte[] ivBytes, byte[] ciphertext) throws GeneralSecurityException {
        System.out.println("Using key " + Base64.getEncoder().encodeToString(key.getEncoded()) + " to decrypt");

        // Set up cipher to decrypt
        IvParameterSpec iv = new IvParameterSpec(ivBytes);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);

        byte[] decodedPlaintext = cipher.doFinal(ciphertext);

        return new String(decodedPlaintext, StandardCharsets.UTF_8);
    }
}