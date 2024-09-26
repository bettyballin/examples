import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectConfig {
    private String clientId;
    private String clientSecret;
    private String jwtTokenUrl;
    private String keyAlgorithm;
    private String keyPath;
    private String subject;
    private String issuer;
    private String audience;
    private String claimKey;
    private String claimValue;
    private String tokenExpiryFrequency;
    private String tokenExpiryUnit;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getJwtTokenUrl() {
        return jwtTokenUrl;
    }

    public void setJwtTokenUrl(String jwtTokenUrl) {
        this.jwtTokenUrl = jwtTokenUrl;
    }

    public String getKeyAlgorithm() {
        return keyAlgorithm;
    }

    public void setKeyAlgorithm(String keyAlgorithm) {
        this.keyAlgorithm = keyAlgorithm;
    }

    public String getKeyPath() {
        return keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }

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

    public String getTokenExpiryFrequency() {
        return tokenExpiryFrequency;
    }

    public void setTokenExpiryFrequency(String tokenExpiryFrequency) {
        this.tokenExpiryFrequency = tokenExpiryFrequency;
    }

    public String getTokenExpiryUnit() {
        return tokenExpiryUnit;
    }

    public void setTokenExpiryUnit(String tokenExpiryUnit) {
        this.tokenExpiryUnit = tokenExpiryUnit;
    }
}