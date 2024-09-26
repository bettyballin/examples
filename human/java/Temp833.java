import java.math.BigInteger;

public class Temp833 {
    public static void main(String[] args) {
        // Example usage
        BigInteger n = new BigInteger("123456789123456789123456789");
        byte[] message = new byte[]{0x01, 0x02, 0x03, 0x04};
        Temp833 temp = new Temp833();
        BigInteger e = temp.calculateE(n, message);
        System.out.println("Calculated e: " + e);
    }

    private BigInteger calculateE(BigInteger n, byte[] message) {
        /* n is curve order value */
        int log2n = n.bitLength();
        /* and message is a hash */
        int messageBitLength = message.length * 8;

        BigInteger e = new BigInteger(1, message);
        /* If message is longer than curve order */
        if (log2n < messageBitLength) {
            /* only log2n bits are taken from the left */
            e = e.shiftRight(messageBitLength - log2n);
        }
        return e;
    }
}