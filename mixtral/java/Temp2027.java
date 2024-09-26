import java.io.ByteArrayInputStream;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp2027 {
    public static void main(String[] args) {
        try {
            String cert = "-----BEGIN CERTIFICATE-----\n" +
                // Your certificate content here
                "-----END CERTIFICATE-----";

            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            ByteArrayInputStream bytes = new ByteArrayInputStream(cert.getBytes());
            X509Certificate certificate1 = (X509Certificate) certFactory.generateCertificate(bytes);

            Security.addProvider(new BouncyCastleProvider());

            String jwtS = "eyJ0eXAiOiJKV1QiLCJhbGciOiJQUzI1NiJ9...";

            // Parse the JWT
            JWT jwt = JWTParser.parse(jwtS);

            // Cast it to a signed JWT
            JWSObject jwsObject = (JWSObject) jwt;

            // Verify signature
            RSAKey rsaKey = new RSAKey.Builder((java.security.interfaces.RSAPublicKey) certificate1.getPublicKey()).build();
            JWSVerifier verifier = new RSASSAVerifier(rsaKey);

            boolean flagSig = jwsObject.verify(verifier);
            System.out.println("Signature is valid: " + flagSig);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}