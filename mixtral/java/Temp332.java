import org.apache.commons.codec.binary.Hex;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp332 {
    public static void main(String[] args) {
        try {
            Temp332 temp = new Temp332();
            byte[] result = temp.sha256digest16("example", "string");
            System.out.println(Hex.encodeHexString(result));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public byte[] sha256digest16(String... list) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        for (String s : list)
            digest.update(s.getBytes());

        return Hex.decodeHex(Hex.encodeHexString(digest.digest()).substring(0, 32).toCharArray());
    }
}