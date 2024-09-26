import java.security.*;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.math.BigInteger;

public class Temp1285 {
    
    public static void main(String[] args) {
        try {
            KeyPair aKeyPair  = generateKeyPair();
            PublicKey publicKey  = aKeyPair.getPublic();
            ECPublicKey ecPublicKey = (ECPublicKey) publicKey;
            byte[] X  = bigIntegerToFixedByteArray(ecPublicKey.getW().getAffineX());
            // Just for demonstration, print the byte array
            for (byte b : X) {
                System.out.format("%02X ", b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static KeyPair generateKeyPair() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        ECGenParameterSpec ecGenParameterSpec = new ECGenParameterSpec("secp256r1");
        keyPairGenerator.initialize(ecGenParameterSpec);
        return keyPairGenerator.generateKeyPair();
    }

    public static byte[] bigIntegerToFixedByteArray(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == 32) {
            return byteArray;
        } else if (byteArray.length > 32) {
            // If the length is greater than 32, truncate it (this shouldn't normally happen for affine X of secp256r1)
            byte[] truncatedByteArray = new byte[32];
            System.arraycopy(byteArray, byteArray.length - 32, truncatedByteArray, 0, 32);
            return truncatedByteArray;
        } else {
            // If the length is less than 32, pad it with leading zeros
            byte[] paddedByteArray = new byte[32];
            System.arraycopy(byteArray, 0, paddedByteArray, 32 - byteArray.length, byteArray.length);
            return paddedByteArray;
        }
    }
}