import java.security.spec.ECPoint;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.util.Base64;
import java.math.BigInteger;

public class Temp479 {
    public static void main(String[] args) {
        try {
            // Generate EC KeyPair for demonstration purposes
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
            kpg.initialize(new ECGenParameterSpec("secp256r1"));
            KeyPair kp = kpg.generateKeyPair();
            ECPublicKey originalPublicKey = (ECPublicKey) kp.getPublic();
            
            // Get the ECPoint from the original public key
            ECPoint originalEcPoint = originalPublicKey.getW();
            
            // Encode the ECPoint as Base64
            byte[] encodedPoint = Base64.getEncoder().encode(originalEcPoint.getAffineX().toByteArray());
            
            // Decode the Base64-encoded string back to byte array
            byte[] decodedPoint = Base64.getDecoder().decode(encodedPoint);
            
            // Create a new ECPoint from the decoded byte array
            ECPoint ecPoint = new ECPoint(new BigInteger(decodedPoint), originalEcPoint.getAffineY());

            // Retrieve the ECParameterSpec from the original public key
            ECParameterSpec ecParameterSpec = originalPublicKey.getParams();
            
            // Create a new ECPublicKey instance from the EC point
            ECPublicKey newPublicKey = new ECPublicKey() {
                @Override
                public ECPoint getW() {
                    return ecPoint;
                }

                @Override
                public ECParameterSpec getParams() {
                    return ecParameterSpec;
                }

                @Override
                public String getAlgorithm() {
                    return "EC";
                }

                @Override
                public String getFormat() {
                    return "X.509";
                }

                @Override
                public byte[] getEncoded() {
                    return originalPublicKey.getEncoded();
                }
            };
            
            System.out.println("Original ECPoint: " + originalEcPoint);
            System.out.println("New ECPoint: " + newPublicKey.getW());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}