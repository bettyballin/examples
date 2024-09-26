public class MyClientDetails extends BaseClientDetails {
    // Fields representing custom column for oauth_client
    private String customField1;
    private String customField2;

    public MyClientDetails() {
        super();
    }

    public MyClientDetails(String clientId, String resourceIds, String scopes, String grantTypes, String authorities, String redirectUris) {
        super(clientId, resourceIds, scopes, grantTypes, authorities, redirectUris);
    }

    // Getters and setters
    public String getCustomField1() {
        return customField1;
    }

    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    public String getCustomField2() {
        return customField2;
    }

    public void setCustomField2(String customField2) {
        this.customField2 = customField2;
    }
}