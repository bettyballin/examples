import java.security.MessageDigest;

public class Temp1458 {
    public static void main(String[] args) {
        try {
            byte[] message = "Hello, world!".getBytes();
            byte[] hash = generateHASH(message);
            System.out.println(bytesToHex(hash));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] generateHASH(byte[] message) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        return messageDigest.digest(message);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}