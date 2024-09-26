import java.math.BigInteger;

public class Temp333 {
    public static void main(String[] args) {
        BigInteger modulus = new BigInteger("123456789012345678901234567890");
        BigInteger sk = new BigInteger("987654321098765432109876543210");
        BigInteger pk = new BigInteger("111111111111111111111111111111");

        System.out.println("Modulus length in bits : " + modulus.bitLength());
        System.out.println("Private exponent length in bits : " + sk.bitLength());
        System.out.println("Public exponent length in bits : " + pk.bitLength());
    }
}