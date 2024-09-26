import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPrivateKeySpec;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.util.Base64;

public class Temp2195 {
    public static void main(String[] args) throws Exception {
        String privateKeyPEM = "MIHtAgEA...(your_private_key)";
        byte[] encodedPrivateKey = Base64.getDecoder().decode(privateKeyPEM);

        ECParameterSpec ecParameters = ECNamedCurveTable.getParameterSpec("secp521r1");
        ECPrivateKeySpec privateKeySpec = new ECPrivateKeySpec(new BigInteger(1, encodedPrivateKey), ecParameters);

        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

        final JwtBuilder jwtBuilder = Jwts.builder()
                .setSubject("713f42c9-7df5-4271-8b53-112f30936c56")
                .signWith(SignatureAlgorithm.ES512, privateKey)
                .setHeaderParam("typ", "JWT");

        System.out.println(jwtBuilder.compact());
    }
}