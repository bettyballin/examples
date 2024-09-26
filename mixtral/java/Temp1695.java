import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.spec.ECPoint;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.interfaces.ECPublicKey;

public class Temp1695 {

    // Helper method to convert BigInteger to byte array
    private static byte[] BigIntegerToByteArray(BigInteger bigInt) {
        byte[] byteArray = bigInt.toByteArray();
        if (byteArray[0] == 0) {
            byte[] tmp = new byte[byteArray.length - 1];
            System.arraycopy(byteArray, 1, tmp, 0, tmp.length);
            return tmp;
        }
        return byteArray;
    }

    public static void main(String[] args) throws Exception {
        // Example values for demonstration purposes
        BigInteger x = new BigInteger("112233445566778899");
        BigInteger y = new BigInteger("998877665544332211");
        
        // Example ECParameterSpec, in a real scenario, acquire this from a proper source
        EllipticCurve curve = new EllipticCurve(
            new java.security.spec.ECFieldFp(new BigInteger("fffffffffffffffffffffffffffffffeffffffffffffffff", 16)),
            new BigInteger("fffffffffffffffffffffffffffffffefffffffffffffffc", 16),
            new BigInteger("fffffffffffffffffffffffffffffffefffffffffffffffc", 16)
        );
        ECParameterSpec ecSpec = new ECParameterSpec(
            curve,
            new ECPoint(
                new BigInteger("fffffffffffffffffffffffffffffffefffffffffffffffc", 16),
                new BigInteger("fffffffffffffffffffffffffffffffefffffffffffffffc", 16)
            ),
            new BigInteger("fffffffffffffffffffffffffffffffefffffffffffffffc", 16),
            1
        );

        // Create ECPublicKey from x, y coordinates and ECParameterSpec
        ECPublicKeySpec pubKeySpec = new ECPublicKeySpec(new ECPoint(x, y), ecSpec);
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        ECPublicKey ecPublic = (ECPublicKey) keyFactory.generatePublic(pubKeySpec);

        ECParameterSpec params = ecPublic.getParams();

        // Get X coordinate
        byte[] publicXCoordinateBytes = BigIntegerToByteArray(ecPublic.getW().getAffineX());

        // Get Y Coordinate
        byte[] publicYCoordinateBytes = BigIntegerToByteArray(ecPublic.getW().getAffineY());

        // Print the byte arrays for demonstration
        System.out.println("X Coordinate: " + java.util.Arrays.toString(publicXCoordinateBytes));
        System.out.println("Y Coordinate: " + java.util.Arrays.toString(publicYCoordinateBytes));
    }
}