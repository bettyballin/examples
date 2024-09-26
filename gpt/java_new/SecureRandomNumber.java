import java.math.BigInteger;
import java.security.SecureRandom;

public class SecureRandomNumber {

    public static BigInteger secureRandomApproximateSize(int numBits, SecureRandom secureRandom) {
        BigInteger randomNum = new BigInteger(numBits, 100, secureRandom);
        return randomNum;
    }

    public static void main(String[] args) {
        SecureRandom secureRandom = new SecureRandom();
        int messageSizeInBits = 256;
        BigInteger secureRandomNumber = secureRandomApproximateSize(messageSizeInBits, secureRandom);
        System.out.println(secureRandomNumber);
    }
}