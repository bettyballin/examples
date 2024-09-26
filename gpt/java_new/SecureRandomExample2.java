import java.math.BigInteger;
import java.security.SecureRandom;

public class SecureRandomExample2 {

    private static final SecureRandom secureRandom = new SecureRandom();

    public static BigInteger secureRandomBigInteger(BigInteger maxRange) {
        BigInteger randomBigInt;
        do {
            randomBigInt = new BigInteger(maxRange.bitLength(), secureRandom);
        } while (randomBigInt.compareTo(maxRange) >= 0);
        return randomBigInt;
    }

    public static void main(String[] args) {
        BigInteger maxRange = new BigInteger("100000000000000000000");
        BigInteger randomNum = secureRandomBigInteger(maxRange);
        System.out.println(randomNum);
    }
}