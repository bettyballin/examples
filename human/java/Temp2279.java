import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger modulus = new BigInteger("12345678901234567890"); // Example modulus
        int Ni = 100; // Example value
        int Nca = 50; // Example value
        int nbytes = Ni - (Nca - 36);
        BigInteger remainder = modulus.divideAndRemainder(BigInteger.valueOf(2).pow(8 * nbytes))[1];
        System.out.println("Remainder: " + remainder);
    }
}