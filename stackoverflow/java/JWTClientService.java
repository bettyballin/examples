import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.io.IOUtils;

public class JWTClientService {

    public String generateJWTToken(ProjectConfig jwtConfig) {
        return Jwts.builder()
                .setSubject(jwtConfig.getSubject())
                .setIssuer(jwtConfig.getIssuer())
                .setExpiration(getExpiryDate(jwtConfig.getTokenExpiryUnit(), jwtConfig.getTokenExpiryFrequency()))
                .setAudience(jwtConfig.getAudience())
                .claim(jwtConfig.getClaimKey(), Boolean.valueOf(jwtConfig.getClaimValue()))
                .signWith(SignatureAlgorithm.RS512, privateKey(jwtConfig))
                .compact();
    }

    private Date getExpiryDate(String tokenExp, String tokenExpFreq) {
        Calendar calendar = Calendar.getInstance();
        int expiry = Integer.parseInt(tokenExp);
        switch (tokenExpFreq.toLowerCase()) {
            case "second":
                calendar.add(Calendar.SECOND, expiry);
                break;
            case "minute":
                calendar.add(Calendar.MINUTE, expiry);
                break;
            case "hour":
                calendar.add(Calendar.HOUR, expiry);
                break;
            case "day":
                calendar.add(Calendar.DATE, expiry);
                break;
            case "month":
                calendar.add(Calendar.MONTH, expiry);
                break;
            default:
                calendar.add(Calendar.HOUR, expiry);
        }
        return calendar.getTime();
    }

    private PrivateKey privateKey(ProjectConfig jwtConfig) {
        PrivateKey privateKey;
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(jwtConfig.getKeyPath())) {
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
            IOUtils.copy(inputStream, byteOutputStream);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(byteOutputStream.toByteArray());
            KeyFactory keyFactory = KeyFactory.getInstance(jwtConfig.getKeyAlgorithm());
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (Exception ex) {
            throw new RuntimeException("Unable to generate private key: " + ex.getMessage(), ex);
        }
        return privateKey;
    }
}