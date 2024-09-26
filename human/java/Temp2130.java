import java.security.InvalidKeyException;

public class Temp2130 {
    public static void main(String[] args) {
        byte[] key = new byte[24];
        try {
            useKey(key);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Uses the first 24 bytes in <code>key</code> as the DES-EDE key.
     * <p>
     * The bytes that constitute the DES-EDE key are those between
     * <code>key[0]</code> and <code>key[23]</code> inclusive
     *
     * @param key the buffer with the DES-EDE key material.
     * @exception InvalidKeyException if the given key material is shorter
     *                                than 24 bytes.
     */
    public static void useKey(byte[] key) throws InvalidKeyException {
        if (key.length < 24) {
            throw new InvalidKeyException("Key material is shorter than 24 bytes");
        }
        // Use the key for DES-EDE encryption/decryption
        System.out.println("Key is valid and can be used for DES-EDE.");
    }
}