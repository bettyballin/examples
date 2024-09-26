import java.math.BigInteger;
import java.util.Arrays;

public class Temp1284 {
    public static void main(String[] args) {
        // Example usage
        BigInteger bi = new BigInteger("123456789");
        int numBytes = 5;
        byte[] result = bigIntegerToFixedByteArray(bi, numBytes);
        System.out.println(Arrays.toString(result));
    }

    public static byte[] bigIntegerToFixedByteArray(BigInteger bi, int numBytes) {
        // Convert the BigInteger to its two's complement representation.
        byte[] twosComplement = bi.toByteArray();

        if (twosComplement.length == numBytes + 1 && twosComplement[0] == 0x00) {
            return Arrays.copyOfRange(twosComplement, 1, twosComplement.length);
        } else if (twosComplement.length < numBytes) {
            byte[] fixedSizeArray = new byte[numBytes];
            System.arraycopy(twosComplement, 0, fixedSizeArray, fixedSizeArray.length - twosComplement.length, twosComplement.length);
            return fixedSizeArray;
        } else if (twosComplement.length > numBytes) {
            throw new IllegalArgumentException("BigInteger value is too large to fit in " + numBytes + " bytes.");
        }

        // If the length matches just return it.
        return twosComplement;
    }
}