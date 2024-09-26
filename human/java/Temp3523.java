public class Temp3523 {
    public static void main(String[] args) {
        String securityMetadataSource = 
            "<security:filter-security-metadata-source>" +
                "<security:intercept-url " +
                    "access=\"hasRole('ROLE_User')\" request-matcher-ref=\"antmatcherServlet\"/>" +
                "<security:intercept-url " +
                    "access=\"hasRole('ROLE_User')\" request-matcher-ref=\"antmatcherMobile\"/>" +
                "<security:intercept-url " +
                    "access=\"hasAnyRole('ROLE_User', 'ROLE_OtherUser', 'ROLE_Guest')\" " +
                "request-matcher-ref=\"...\" />" +
            "</security:filter-security-metadata-source>";

        System.out.println(securityMetadataSource);
    }
}