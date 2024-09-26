import java.util.Base64;

public class Temp1230 {
    public static void main(String[] args) {
        String key = "uQsaW+WMUrjcsq1HMf+2JQ==";
        byte[] keyBytes = Base64.getDecoder().decode(key);
        
        System.out.println("Key in Hex: " + bytesToHex(keyBytes));
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}