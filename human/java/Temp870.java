import java.nio.charset.StandardCharsets;

public class Temp870 {
    public static void main(String[] args) {
        byte[] enCodeFormat = "example".getBytes(StandardCharsets.UTF_8);
        System.out.println("Key: " + ByteUtil.parseByte2HexStr(enCodeFormat));
    }
}

class ByteUtil {
    public static String parseByte2HexStr(byte[] buf) {
        StringBuilder sb = new StringBuilder();
        for (byte b : buf) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
}