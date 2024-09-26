import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class Temp167 {
    public static void main(String[] args) {
        try {
            byte[] data = Hex.decodeHex("A5DA123456789B00000000".toCharArray());
            for (byte b : data) {
                System.out.printf("%02X ", b);
            }
        } catch (DecoderException e) {
            e.printStackTrace();
        }
    }
}