import java.math.BigInteger;

public class ModularArithmetic {
    public static void main(String[] args) {
        BigInteger two = new BigInteger("2");
        BigInteger twelve = new BigInteger("12");
        BigInteger twentyThree = new BigInteger("23");

        // Use the Extended Euclidean Algorithm to find the modular inverse
        BigInteger inverse = two.modInverse(twentyThree);
        BigInteger x = inverse.multiply(twelve).mod(twentyThree);

        System.out.println("The value of x is: " + x);
    }
}