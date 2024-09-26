import java.math.BigInteger;

public class Temp1696 {
    public static void main(String[] args) {
        BigInteger bigInt = new BigInteger("12345678901234567890");
        int length = 16;
        byte[] result = BigIntegerToByteArray(bigInt, length);
        for (byte b : result) {
            System.out.printf("%02x ", b);
        }
    }

    public static byte[] BigIntegerToByteArray(final BigInteger bigInt, final int length) {
        if (bigInt == null || bigInt.signum() < 0) {
            throw new IllegalArgumentException("Argument cannot be negative or zero");
        }

        // Convert the number to a ByteBuffer
        byte[] bytes = new byte[length];
        BigInteger tempBigInt = bigInt; // Copy of the original BigInteger to perform operations

        for (int i = bytes.length - 1; i >= 0 && (tempBigInt != null && tempBigInt.signum() > 0); --i) {
            int nextByteValue = tempBigInt.mod(BigInteger.valueOf(256)).intValue();

            bytes[i] = (byte) (nextByteValue & 0xFF);

            if (tempBigInt != null && tempBigInt.signum() > 0) {
                // Subtract the value of next byte from our BigInteger
                tempBigInt = tempBigInt.subtract(BigInteger.valueOf(nextByteValue));

                // Divide by 256
                tempBigInt = tempBigInt.divide(BigInteger.valueOf(256));
            }
        }
        return bytes;
    }
}