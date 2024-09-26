import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

public class Temp1497 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
        ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256r1");
        keyGen.initialize(ecSpec);
        KeyPair pair = keyGen.generateKeyPair();
        
        ECParameterSpec ecParamSpec = ((ECPublicKey) pair.getPublic()).getParams();
        ECPoint ecPoint = ((ECPublicKey) pair.getPublic()).getW();
        
        System.out.println(ecPoint.getAffineX().toString(16));
        System.out.println(ecPoint.getAffineY().toString(16));
    }
}