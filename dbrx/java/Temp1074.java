import java.math.BigInteger;
import java.util.Arrays;

public class Temp1074 {
    public static void main(String[] args) {
        // Example usage
        byte[] signature = new byte[]{0x30, 0x45, 0x02, 0x20, 0x5f, 0x2d, 0x2f, 0x2a, 0x02, 0x21, 0x00, 0xc3, 0x4e, 0xb4, 0x4c, 0x7a, 0x6e, 0x5a, 0x72, 0x76, 0x50, 0x3a, 0x43, 0x41, 0x3a, 0x62, 0x35, 0x3a, 0x39, 0x33, 0x33, 0x3a, 0x39, 0x66, 0x3a, 0x32, 0x32, 0x3a, 0x39, 0x39, 0x3a, 0x66, 0x33, 0x3a, 0x39, 0x39, 0x3a, 0x39, 0x33, 0x3a, 0x33, 0x35, 0x3a, 0x39, 0x39, 0x3a, 0x66, 0x35};
        
        try {
            byte[] r = extractR(signature);
            byte[] s = extractS(signature);
            
            System.out.println("R: " + Arrays.toString(r));
            System.out.println("S: " + Arrays.toString(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] extractR(byte[] signature) throws Exception {
        int startR = (signature[1] & 0x80) != 0 ? 3 : 2;
        int lengthR = signature[startR + 1];
        return Arrays.copyOfRange(signature, startR + 2, startR + 2 + lengthR);
    }

    public static byte[] extractS(byte[] signature) throws Exception {
        int startR = (signature[1] & 0x80) != 0 ? 3 : 2;
        int lengthR = signature[startR + 1];
        int startS = startR + 2 + lengthR + 1;
        int lengthS = signature[startS];
        return Arrays.copyOfRange(signature, startS + 1, startS + 1 + lengthS);
    }

    public static byte[] toByteArray(BigInteger value) {
        byte[] bytes = value.toByteArray();
        if (bytes[0] == 0 && bytes.length > 1)
            return Arrays.copyOfRange(bytes, 1, bytes.length); // remove leading zero-byte
        else
            return bytes;
    }
}