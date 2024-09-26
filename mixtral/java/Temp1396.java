import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.security.SecureRandom;

public class Temp1396 {
    public static void main(String[] args) {
        SecureRandom r = new SecureRandom();
        byte[] bytes = new byte[8]; // 64 bits
        r.nextBytes(bytes);
        BigInteger bigInt = new BigInteger(1, bytes);
        double maxValue = Double.MAX_VALUE;
        double minValue = -Double.MAX_VALUE;

        // Scale the random number to fit within your desired range
        BigInteger range = BigDecimal.valueOf(maxValue - minValue).multiply(BigDecimal.TEN).toBigInteger();
        BigInteger offset = BigDecimal.valueOf(minValue * 10).toBigInteger();
        bigInt = bigInt.mod(range).add(offset);

        double result = new BigDecimal(bigInt, MathContext.DECIMAL64).divide(BigDecimal.TEN, MathContext.DECIMAL64).doubleValue();

        System.out.println(result);
    }
}