import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.math.ec.ECPoint;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Temp217 {
    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        X9ECParameters x9 = CustomNamedCurves.getByName("P-224"); // or whatever curve you want to use
        ECPoint g = x9.getG();
        BigInteger n = x9.getN();
        int nBitLength = n.bitLength();
        BigInteger x;
        do {
            x = new BigInteger(nBitLength, random);
        } while (x.equals(ZERO) || (x.compareTo(n) >= 0));
        ECPoint randomPoint = g.multiply(x);
        
        System.out.println("Random Point: " + randomPoint);
    }
}