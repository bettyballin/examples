import lombok.Data;

@Data
public class TokenServiceProperties {
    private String aadB2bUrl;
    private String aadB2bClientId;
    private String aadB2bResource;

    public static void main(String[] args) {
        TokenServiceProperties properties = new TokenServiceProperties();
        properties.setAadB2bUrl("https://example.com");
        properties.setAadB2bClientId("client-id");
        properties.setAadB2bResource("resource");

        System.out.println("AAD B2B URL: " + properties.getAadB2bUrl());
        System.out.println("AAD B2B Client ID: " + properties.getAadB2bClientId());
        System.out.println("AAD B2B Resource: " + properties.getAadB2bResource());
    }
}