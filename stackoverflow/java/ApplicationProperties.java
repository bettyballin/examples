public class ApplicationProperties {
    private String userInfoUri;

    public String getUserInfoUri() {
        return userInfoUri;
    }

    public void setUserInfoUri(String userInfoUri) {
        this.userInfoUri = userInfoUri;
    }

    public static void main(String[] args) {
        ApplicationProperties properties = new ApplicationProperties();
        properties.setUserInfoUri("http://localhost:6001/uaa/oauth/user/me");
        System.out.println(properties.getUserInfoUri());
    }
}