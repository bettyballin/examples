import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Calendar;
import java.util.Date;

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

            case "second": {
                calendar.add(Calendar.SECOND, expiry);
                break;
            }
            case "minute": {
                calendar.add(Calendar.MINUTE, expiry);
                break;
            }
            case "hour": {
                calendar.add(Calendar.HOUR, expiry);
                break;
            }
            case "day": {
                calendar.add(Calendar.DATE, expiry);
                break;
            }
            case "month": {
                calendar.add(Calendar.MONTH, expiry);
                break;
            }
            default: {
                calendar.add(Calendar.HOUR, expiry);
                break;
            }
        }
        return calendar.getTime();
    }

    private PrivateKey privateKey(ProjectConfig jwtConfig) {
        PrivateKey privateKey = null;
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(jwtConfig.getKeyPath());
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
            assert inputStream != null;
            IOUtils.copy(inputStream, byteOutputStream);
            byte[] privKeyByteArray = byteOutputStream.toByteArray();
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privKeyByteArray);

            KeyFactory keyFactory = KeyFactory.getInstance(jwtConfig.getKeyAlgorithm());

            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (Exception ex) {
            throw new RuntimeException("Unable to generate private key..." + ex.getMessage());
        }
        return privateKey;
    }

    public static void main(String[] args) {
        ProjectConfig config = new ProjectConfig();
        config.setSubject("subject");
        config.setIssuer("issuer");
        config.setTokenExpiryUnit("hour");
        config.setTokenExpiryFrequency("1");
        config.setAudience("audience");
        config.setClaimKey("claimKey");
        config.setClaimValue("true");
        config.setKeyPath("privateKey.pkcs8");
        config.setKeyAlgorithm("RSA");

        JWTClientService jwtClientService = new JWTClientService();
        String token = jwtClientService.generateJWTToken(config);
        System.out.println(token);
    }
}

class ProjectConfig {
    private String subject;
    private String issuer;
    private String tokenExpiryUnit;
    private String tokenExpiryFrequency;
    private String audience;
    private String claimKey;
    private String claimValue;
    private String keyPath;
    private String keyAlgorithm;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getTokenExpiryUnit() {
        return tokenExpiryUnit;
    }

    public void setTokenExpiryUnit(String tokenExpiryUnit) {
        this.tokenExpiryUnit = tokenExpiryUnit;
    }

    public String getTokenExpiryFrequency() {
        return tokenExpiryFrequency;
    }

    public void setTokenExpiryFrequency(String tokenExpiryFrequency) {
        this.tokenExpiryFrequency = tokenExpiryFrequency;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getClaimKey() {
        return claimKey;
    }

    public void setClaimKey(String claimKey) {
        this.claimKey = claimKey;
    }

    public String getClaimValue() {
        return claimValue;
    }

    public void setClaimValue(String claimValue) {
        this.claimValue = claimValue;
    }

    public String getKeyPath() {
        return keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath =