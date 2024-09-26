public class Temp2581 {
    public static void main(String[] args) {
        String authServerUrl = "https://${keycloak.host}/auth/";
        String realm = "master";
        String resource = "${client.name}";
        String secret = "${client.secret}";
        boolean enableBasicAuth = true;
        boolean bearerOnly = true;

        System.out.println("keycloak.auth-server-url=" + authServerUrl);
        System.out.println("keycloak.realm=" + realm);
        System.out.println("keycloak.resource=" + resource);
        System.out.println("keycloak.credentials.secret=" + secret);
        System.out.println("keycloak.enable-basic-auth=" + enableBasicAuth);
        System.out.println("keycloak.bearer-only=" + bearerOnly);
    }
}