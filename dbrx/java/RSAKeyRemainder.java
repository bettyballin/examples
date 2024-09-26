import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import java.math.BigInteger;

public class RSAKeyRemainder {

    public static byte[] getPublicKeyRemainder(RSAPrivateCrtKeyParameters key, int NCA) {
        BigInteger modulus = key.getModulus();
        int remainderLength = (modulus.bitLength() / 8) - NCA + 36;
        return modulus.shiftRight(NCA * 8).toByteArray();
    }
    
    public static void main(String[] args) {
        // Example use of getPublicKeyRemainder method
        BigInteger modulus = new BigInteger("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        BigInteger publicExponent = new BigInteger("65537");
        BigInteger privateExponent = new BigInteger("12345678901234567890123456789012345678901234567890");
        BigInteger p = new BigInteger("1234567890123456789012345678901234567890");
        BigInteger q = new BigInteger("1234567890123456789012345678901234567890");
        BigInteger dP = new BigInteger("1234567890123456789012345678901234567890");
        BigInteger dQ = new BigInteger("1234567890123456789012345678901234567890");
        BigInteger qInv = new BigInteger("1234567890123456789012345678901234567890");

        RSAPrivateCrtKeyParameters key = new RSAPrivateCrtKeyParameters(modulus, publicExponent, privateExponent, p, q, dP, dQ, qInv);
        
        byte[] remainder = getPublicKeyRemainder(key, 10);
        System.out.println("Remainder: " + new BigInteger(remainder).toString());
    }
}