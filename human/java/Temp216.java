import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.jce.ECPointUtil;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveGenParameterSpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;
import java.security.spec.ECFieldFp;
import java.security.spec.EllipticCurve;
import java.math.BigInteger;

public class Temp216 {
    public static void main(String[] args) {
        // Add BouncyCastle as a security provider
        Security.addProvider(new BouncyCastleProvider());

        // Define the elliptic curve parameters (using secp256k1 for example)
        BigInteger p = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16);
        BigInteger a = new BigInteger("0", 16);
        BigInteger b = new BigInteger("7", 16);
        BigInteger x = new BigInteger("79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798", 16);
        BigInteger y = new BigInteger("483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8", 16);

        ECCurve curve = new ECCurve.Fp(p, a, b);
        ECFieldElement xFieldElement = curve.fromBigInteger(x);
        ECFieldElement yFieldElement = curve.fromBigInteger(y);

        ECFieldElement lhs = yFieldElement.multiply(yFieldElement); // y^2
        ECFieldElement rhs = xFieldElement.multiply(xFieldElement).multiply(xFieldElement) // x^3
                .add(curve.getA().multiply(xFieldElement)) // + ax
                .add(curve.getB()); // + b

        boolean pointIsOnCurve = lhs.equals(rhs);

        System.out.println("Point is on the curve: " + pointIsOnCurve);
    }
}