import java.math.BigInteger;
import java.util.Random;

public class Temp464 {
    public static void main(String[] args) {
        BigInteger modInv = BigInteger.probablePrime(128, new Random());
        System.out.println(modInv);
    }
}