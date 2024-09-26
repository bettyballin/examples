import java.math.BigInteger;
import java.util.Random;

public class Temp1008 {
    public static void main(String[] args) {
        int bitLength = 128;
        int certainty = 10;
        Random rnd = new Random();
        
        BigInteger bigInteger = new BigInteger(bitLength, certainty, rnd);
        System.out.println(bigInteger);
    }
}