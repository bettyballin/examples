import java.security.*;
import java.security.spec.*;
import java.util.Base64;

import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Temp1380 {

    public static void main(String[] args) {
        // Example W value (in this case, it should be a 65-byte array for P-256 keys)
        // This is just a placeholder, in a real scenario you'd have the actual 'w' values.
        byte[] w = Base64.getDecoder().decode("MFYwEAYHKoZIzj0CAQYFK4EEAAoDQgAE6y9+O1+eV7+G4O3hE2v7E8vJmM6oXn4zQ5pN5bZP1YtJ7Pq3WyFZB4lHfS6Z5O5F1uVtOq+K5l2FzYg4ZB9iTw==");

        ECPublicKey key = generateP256PublicKeyFromFlatW(w);
        System.out.println(key);
    }

    public static ECPublicKey generateP256PublicKeyFromFlatW(byte[] w) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            ECNamedCurveParameterSpec parameterSpec = ECNamedCurveTable.getParameterSpec("P-256");
            ECPoint point = ECPointUtil.decodePoint(parameterSpec.getCurve(), w);
            ECPublicKeySpec keySpec = new ECPublicKeySpec(point, parameterSpec);
            return (ECPublicKey) keyFactory.generatePublic(keySpec);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}