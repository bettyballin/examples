import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.math.ec.ECCurve;

public class Temp1044 {
    public static void main(String[] args) throws Exception {
        String ecCurveName = "secp256r1";
        
        // Generating Key Pair on one end let's say client-side.
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", "BC");
        kpg.initialize(new ECNamedCurveParameterSpec(ecCurveName), new SecureRandom());
        KeyPair keyPair = kpg.generateKeyPair();
        ECPublicKey ephemeralPublicKey = (ECPublicKey) keyPair.getPublic();
        ECPrivateKey clientEphemeralPrivateKey = (ECPrivateKey) keyPair.getPrivate();

        // Sharing the public key with server-side.
        String eCClientEphemeralPublicKeyString =
            "04" + ephemeralPublicKey.getW().getAffineX().toString(16)
                + ephemeralPublicKey.getW().getAffineY().toString(16);

        // Convert to bytes
        byte[] clientECPublicKeybytes = hexStringToByteArray(eCClientEphemeralPublicKeyString);

        ECParameterSpec ecParameterSpec = ECNamedCurveTable.getParameterSpec(ecCurveName);
        ECCurve curve = ecParameterSpec.getCurve();
        ECPublicKeySpec pubKeySpec = new ECPublicKeySpec(curve.decodePoint(clientECPublicKeybytes), ecParameterSpec);

        // Server-side generates its own private key
        String serverprivateKeyBase64 = "your_server_private_key_base64_here"; // Replace with actual key
        KeyFactory kf = KeyFactory.getInstance("EC", "BC");
        PKCS8EncodedKeySpec privateKeySpec =
            new PKCS8EncodedKeySpec(Base64.decode(serverprivateKeyBase64));
        PrivateKey serverEphemeralPrivateKey = kf.generatePrivate(privateKeySpec);

        // Now you have both serverEphemeralPrivateKey and pubKeySpec to work with
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}