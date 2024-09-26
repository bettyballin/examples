import java.math.BigInteger;
import java.security.SecureRandom;
import javax.crypto.spec.IvParameterSpec;
import java.io.File;

public class Temp270 {
    public static void main(String[] args) {
        int BLOCK_SIZE = 16;
        BigInteger MODULUS = BigInteger.ONE.shiftLeft(BLOCK_SIZE * 8);
        
        // Example initialization of the file and IV for demonstration
        File file = new File("example.txt");
        byte[] iv = new byte[BLOCK_SIZE];
        new SecureRandom().nextBytes(iv); // Generate a random IV for demonstration
        
        // Compute the index of the block to which data will be appended
        BigInteger block = BigInteger.valueOf(file.length() / BLOCK_SIZE);
        // Add the block to the nonce to find the current counter
        BigInteger nonce = new BigInteger(1, iv);
        byte[] tmp = nonce.add(block).mod(MODULUS).toByteArray();
        // Right-justify the counter value in a block-sized array
        byte[] ctr = new byte[BLOCK_SIZE];
        System.arraycopy(tmp, 0, ctr, BLOCK_SIZE - tmp.length, tmp.length);
        // Use this to initialize the appending cipher
        IvParameterSpec param = new IvParameterSpec(ctr);
        
        // Output for verification
        System.out.println("IV: " + bytesToHex(iv));
        System.out.println("Counter: " + bytesToHex(ctr));
    }
    
    // Helper method to convert byte array to hex string for readable output
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}