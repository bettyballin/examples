import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

@Component
public class JwtTokenVerifier {

    // please input your jwt token & public key here
    public static final String jwtToken = ""; // This should be used or removed as it's not in use
    public static final String publicKey = "";

    public boolean isTokenValid(String token) {
        try {
            buildJWTVerifier().verify(token.replace("Bearer ", ""));
            return true;
        } catch (CertificateException | JWTVerificationException e) {
            e.printStackTrace();
            return false;
        }
    }

    private JWTVerifier buildJWTVerifier() throws CertificateException {
        Algorithm algo = Algorithm.RSA256(getRSAPublicKey(), null);
        return JWT.require(algo).build();
    }

    private RSAPublicKey getRSAPublicKey() throws CertificateException {
        byte[] decode = Base64.getDecoder().decode(publicKey);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(decode);
        CertificateFactory factory = CertificateFactory.getInstance("X.509");
        RSAPublicKey publicKey = (RSAPublicKey) factory.generateCertificate(inputStream).getPublicKey();
        return publicKey;
    }
}