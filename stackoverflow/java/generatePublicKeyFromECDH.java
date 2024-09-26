import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import org.bouncycastle.math.ec.ECPoint;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

public PublicKey generatePublicKeyFromECDH(byte[] encodedKeyBytes)
        throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {
    ECParameterSpec params = ECNamedCurveTable.getParameterSpec("secp256r1");

    ECPoint ecPoint = null;
    ObjectMapper mapper = new ObjectMapper(new CBORFactory());
    try {
        ecPoint = mapper.readValue(encodedKeyBytes, ECPoint.class);
    } catch (IOException e) {
        e.printStackTrace();
    }

    ECPublicKeySpec publicKeySpec = new ECPublicKeySpec(ecPoint, params);
    KeyFactory kf = KeyFactory.getInstance("EC", "BC");
    PublicKey pb = kf.generatePublic(publicKeySpec);
    return pb;
}