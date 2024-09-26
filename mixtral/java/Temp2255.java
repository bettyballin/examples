import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;

public class Temp2255 {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
        ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256k1");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        keyGen.initialize(ecSpec, random);
        KeyPair pair = keyGen.generateKeyPair();

        ECPublicKey publicKey = (ECPublicKey) pair.getPublic();
        ECParameterSpec params = publicKey.getParams();
        
        // Get the underlying ECPoint
        java.security.spec.EllipticCurve ec = params.getCurve();
        java.security.spec.ECPoint point = publicKey.getW();
        
        // Now you can use BouncyCastle methods on this point
        byte[] xCoord = ((BigInteger)point.getAffineX()).toByteArray();
        byte[] yCoord = ((BigInteger)point.getAffineY()).toByteArray();
        
        byte[] compressedPointBytes = new byte[xCoord.length + (yCoord[0] % 2 == 0 ? 1 : 2)];
        compressedPointBytes[0] = ((BigInteger)point.getAffineY()).signum() == -1 ? (byte)0x03 : (byte)0x02;
        System.arraycopy(xCoord, 0, compressedPointBytes, 1, xCoord.length);
        
        for (byte b : compressedPointBytes) {
            System.out.printf("%02X", b);
        }
    }
}