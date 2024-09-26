import org.apache.commons.codec.binary.Hex;
import java.nio.charset.StandardCharsets;

public class Temp1228 {
    public static void main(String[] args) {
        String hexString = "75517361572b574d55726a63737131484d662b324a513d3d";
        try {
            byte[] secretKey = Hex.decodeHex(hexString.toCharArray());
            System.out.println(new String(secretKey, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}