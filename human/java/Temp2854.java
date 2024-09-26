import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp2854 {
    public static void main(String[] args) throws Exception {
        // Sample EC public key in Base64 format
        String publicKeyBase64 = "MFYwEAYHKoZIzj0CAQYFK4EEAAoDQgAE5Ae8P+7mF82a9g9GZ+hGx7zJ6X4F6k7Gm2y8H8HR1VgVbqN68dZ8Gz9P3N0c7jG6QxV3vC4xErZQyC5XYH6bDA==";
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyBase64);

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        BigInteger affineX = ((ECPublicKey) publicKey).getW().getAffineX();
        BigInteger affineY = ((ECPublicKey) publicKey).getW().getAffineY();

        printCoordinateInfo(affineX, "X");
        System.out.println();
        printCoordinateInfo(affineY, "Y");
    }

    public static void printCoordinateInfo(BigInteger coordinate, String label) {
        System.out.println(label + ": " + coordinate.toString(16).toUpperCase());
    }

    // Simple interface to match the cast in the main method.
    public interface ECPublicKey extends PublicKey {
        ECPoint getW();
    }
}