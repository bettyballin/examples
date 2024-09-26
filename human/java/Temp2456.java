import java.math.BigInteger;

public class Temp2456 {
    public static void main(String[] args) {
        RSAPublicKey rsaPublicKey = new RSAPublicKey(new BigInteger("123456789"), new BigInteger("65537"));
        System.out.println("Modulus: " + rsaPublicKey.modulus);
        System.out.println("Public Exponent: " + rsaPublicKey.publicExponent);
    }
}

class RSAPublicKey {
    public BigInteger modulus;
    public BigInteger publicExponent;

    public RSAPublicKey(BigInteger modulus, BigInteger publicExponent) {
        this.modulus = modulus;
        this.publicExponent = publicExponent;
    }
}