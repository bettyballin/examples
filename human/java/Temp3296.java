public class Temp3296 {
    public static void main(String[] args) {
        String keycloakHost = "KEYCLOAK_HOST";
        String realmName = "REALM_NAME";
        String endpoint = String.format("POST %s/auth/admin/realms/%s/partialImport", keycloakHost, realmName);
        System.out.println(endpoint);
    }
}