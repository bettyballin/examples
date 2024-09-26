import java.security.*;
import java.math.BigInteger;

public class Temp1077 {
    public static void main(String[] args) {
        Temp1077 temp = new Temp1077();
        System.out.println(temp.getUniqueKey());
    }

    public String getUniqueKey() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32];

        // Fill the array with securely generated random numbers
        random.nextBytes(bytes);

        BigInteger bi = new BigInteger(1, bytes).abs();

        return String.format("%0" + (bytes.length << 1) + "x", bi);
    }
}