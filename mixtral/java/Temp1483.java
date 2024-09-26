import java.math.BigInteger;

public class Temp1483 {
    public static void main(String[] args) {
        // Example values for testing the ElGaMalVerification method
        BigInteger prime = new BigInteger("23");
        BigInteger generator = new BigInteger("5");
        BigInteger publicKey = new BigInteger("8");
        BigInteger message = new BigInteger("7");
        BigInteger r = new BigInteger("3");
        BigInteger s = new BigInteger("10");
        
        boolean isValid = ElGaMalVerification(prime, generator, publicKey, message, r, s);
        System.out.println("Verification result: " + isValid);
    }

    public static boolean ElGaMalVerification(BigInteger prime, BigInteger generator, BigInteger publicKey, BigInteger message, BigInteger r, BigInteger s) {
        if (r.compareTo(BigInteger.valueOf(1)) < 0 || r.compareTo(prime.subtract(BigInteger.ONE)) > 0) {
            return false;
        }
        if (s.compareTo(BigInteger.valueOf(1)) < 0 || s.compareTo(prime.subtract(BigInteger.ONE)) > 0) {
            return false;
        }

        BigInteger v1 = generator.modPow(message, prime);
        BigInteger v2 = (publicKey.modPow(r, prime).multiply(r.modPow(s, prime))).mod(prime);

        return v1.equals(v2);
    }
}