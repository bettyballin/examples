import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECParameterSpec;

import java.io.IOException;
import java.security.*;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;

public class ECDHKeyGenerator {

    public static class ECPointECDH {
        private ECPoint ecPoint;

        public ECPoint getEcPoint() {
            return ecPoint;
        }

        public void setEcPoint(ECPoint ecPoint) {
            this.ecPoint = ecPoint;
        }
    }

    public PublicKey generatePublicKeyFromECDH(byte[] encodedKeyBytes)
            throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {
        ECParameterSpec params2 = ECNamedCurveTable.getParameterSpec("secp256r1");

        ECPointECDH ecPoint = null;
        ObjectMapper mapper = new ObjectMapper(new CBORFactory());
        try {
            ecPoint = mapper.readValue(encodedKeyBytes, ECPointECDH.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ECPublicKeySpec publicKeySpec = new ECPublicKeySpec(ecPoint.getEcPoint(), params2);
        KeyFactory kf = KeyFactory.getInstance("EC", "BC");
        PublicKey pb = kf.generatePublic(publicKeySpec);
        return pb;
    }

    public static void main(String[] args) {
        // Example usage
        ECDHKeyGenerator generator = new ECDHKeyGenerator();
        byte[] encodedKeyBytes = {}; // provide your CBOR encoded key bytes here
        try {
            PublicKey publicKey = generator.generatePublicKeyFromECDH(encodedKeyBytes);
            System.out.println(publicKey);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}