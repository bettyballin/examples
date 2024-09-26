import java.nio.charset.StandardCharsets;

public class Temp31 {
    public static void main(String[] args) {
        int i = 1; // Example initialization
        int j = 2; // Example initialization
        int k = 3; // Example initialization
        int repeat = 4; // Example initialization

        int count = i * repeat * repeat + j * repeat + k;
        byte[] myKeyArray = new byte[13]; // Example initialization
        byte[] keyBytes = new byte[16];

        System.arraycopy(myKeyArray, 0, keyBytes, 0, myKeyArray.length);
        keyBytes[13] = (byte) ((count >> 16) & 0xFF);
        keyBytes[14] = (byte) ((count >> 8) & 0xFF);
        keyBytes[15] = (byte) (count & 0xFF);
        String myKey = new String(keyBytes, StandardCharsets.UTF_8);

        System.out.println(myKey); // Example output
    }
}