import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.ECPoint;
import java.util.Base64;

public class Temp1870 {
    public static void main(String[] args) {
        try {
            BigInteger x = new BigInteger(1, Base64.getDecoder().decode("your_x"));
            BigInteger y = new BigInteger(1, Base64.getDecoder().decode("your_y"));
            ECPoint ecPoint = new ECPoint(x, y);

            // Example curve parameters (replace with your actual parameters)
            BigInteger p = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F", 16);
            BigInteger a = new BigInteger("0", 16);
            BigInteger b = new BigInteger("7", 16);
            BigInteger gx = new BigInteger("79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798", 16);
            BigInteger gy = new BigInteger("483ADA7726A3C4655DA4FBFC0E1108A8FD17B448A68554199C47D08FFB10D4B8", 16);
            BigInteger n = new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141", 16);
            int h = 1;

            ECParameterSpec params = new ECParameterSpec(new java.security.spec.EllipticCurve(
                    new java.security.spec.ECFieldFp(p), a, b), new ECPoint(gx, gy), n, h);

            KeyFactory keyFact = KeyFactory.getInstance("EC");
            PublicKey publicKey = keyFact.generatePublic(new ECPublicKeySpec(ecPoint, params));

            System.out.println("Public Key: " + publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}