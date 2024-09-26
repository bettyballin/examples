import java.math.BigInteger;

public class Temp822 {
    public static void main(String[] args) {
        BigInteger[] sig = generateSignature(new byte[]{0x01, 0x02, 0x03, 0x04});
        for (BigInteger bi : sig) {
            System.out.println(bi);
        }
    }

    public static BigInteger[] generateSignature(byte[] hash) {
        // Mock implementation for generateSignature
        BigInteger[] signature = new BigInteger[2];
        signature[0] = new BigInteger(1, hash); // Example conversion
        signature[1] = new BigInteger(1, hash); // Example conversion
        return signature;
    }
}