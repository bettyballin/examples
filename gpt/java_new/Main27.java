import java.security.SecureRandom;

public class Main27 {

    public static void main(String[] args) {
        byte[] key = generateAESKey(128); // For a 128-bit key
        System.out.println(bytesToHex(key)); // If you want to see it as a hexadecimal string
    }

    public static byte[] generateAESKey(int keySize) {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[keySize / 8];
        random.nextBytes(key);
        return key;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte aByte : bytes) {
            String hex = Integer.toHexString(0xff & aByte);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}