import java.security.MessageDigest;

public class Temp3366 {
    public static void main(String[] args) {
        byte[] data = "example".getBytes();
        byte[] result = MD5(data);
        if (result != null) {
            System.out.println(bytesToHex(result));
        } else {
            System.out.println("MD5 calculation failed");
        }
    }

    public static byte[] MD5(byte[] data) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(data);
            return messageDigest.digest();
        } catch (Exception e) {
            // any processing
            e.printStackTrace();
            return null;
        }
    }
    
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}