import com.yourlibrary.Skip32Cipher;

public class Skip32Example {

    private static final byte[] key = {
        // 10-byte secret key
        (byte)0x00, (byte)0x01, (byte)0x02, (byte)0x03, 
        (byte)0x04, (byte)0x05, (byte)0x06, (byte)0x07, 
        (byte)0x08, (byte)0x09
    };

    public static void main(String[] args) {
        Skip32Cipher skip32 = new Skip32Cipher(key);

        // Encrypt an integer value
        int idToEncrypt = 12345;
        int encryptedId = skip32.encrypt(idToEncrypt);
        System.out.println("Encrypted ID: " + encryptedId);

        // Decrypt the integer value
        int decryptedId = skip32.decrypt(encryptedId);
        System.out.println("Decrypted ID: " + decryptedId);
    }
}