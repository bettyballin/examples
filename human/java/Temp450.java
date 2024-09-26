import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Temp450 {
    public static void main(String[] args) throws Exception {
        PBEKeySpec pbeKeySpec;
        PBEParameterSpec pbeParamSpec;
        SecretKeyFactory keyFac;

        // Salt
        byte[] salt = {
            (byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c,
            (byte)0x7e, (byte)0xc8, (byte)0xee, (byte)0x99
        };

        // Iteration count
        int count = 20;

        // Create PBE parameter set
        pbeParamSpec = new PBEParameterSpec(salt, count);

        // Prompt user for encryption password.
        // Collect user password as char array (using the
        // "readPasswd" method from above), and convert
        // it into a SecretKey object, using a PBE key
        // factory.
        System.out.print("Enter encryption password:  ");
        System.out.flush();
        pbeKeySpec = new PBEKeySpec(readPasswd(System.in));
        keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
        SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec);

        // Create PBE Cipher
        Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");

        // Initialize PBE Cipher with key and parameters
        pbeCipher.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);

        // Our cleartext
        byte[] cleartext = "This is another example".getBytes();

        // Encrypt the cleartext
        byte[] ciphertext = pbeCipher.doFinal(cleartext);

        // Print the ciphertext in hexadecimal form
        System.out.println("Ciphertext: " + bytesToHex(ciphertext));
    }

    // Method to read password from InputStream
    private static char[] readPasswd(InputStream in) throws IOException {
        Console console = System.console();
        if (console != null) {
            return console.readPassword();
        }

        byte[] passwdBytes = new byte[128];
        int length = in.read(passwdBytes);
        if (length == -1) {
            throw new IOException("No password provided");
        }
        return new String(passwdBytes, 0, length).trim().toCharArray();
    }

    // Method to convert byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}