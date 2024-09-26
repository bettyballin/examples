import java.util.Base64;

public class Temp1226 {
    public static void main(String[] args) {
        String base64String = "uQsaW+WMUrjcsq1HMf+2JQ==";
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);
        String hexString = bytesToHex(decodedBytes);
        System.out.println("Hex String: " + hexString);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}