import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Temp1298 {

    public static void main(String[] args) {
        String password = "mypassword";
        int keySize = 256;
        int ivSize = 128;
        byte[] saltBytes = "salt".getBytes(StandardCharsets.UTF_8);
        
        byte[] key = new byte[keySize / 8];
        byte[] iv = new byte[ivSize / 8];
        
        try {
            EvpKDF(password.getBytes(StandardCharsets.UTF_8), keySize, ivSize, saltBytes, key, iv);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        System.out.println("Key: " + Arrays.toString(key));
        System.out.println("IV: " + Arrays.toString(iv));
    }

    public static void EvpKDF(byte[] password, int keySize, int ivSize, byte[] salt, byte[] key, byte[] iv) throws NoSuchAlgorithmException {
        final int hashLength = 16;
        final int totalLength = keySize / 8 + ivSize / 8;
        byte[] derivedBytes = new byte[totalLength];
        int derivedLength = 0;

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] block = null;

        while (derivedLength < totalLength) {
            if (block != null) {
                md.update(block);
            }
            md.update(password);
            md.update(salt);
            block = md.digest();
            md.reset();

            int blockLength = Math.min(hashLength, totalLength - derivedLength);
            System.arraycopy(block, 0, derivedBytes, derivedLength, blockLength);
            derivedLength += blockLength;
        }

        System.arraycopy(derivedBytes, 0, key, 0, keySize / 8);
        System.arraycopy(derivedBytes, keySize / 8, iv, 0, ivSize / 8);
    }
}