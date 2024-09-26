public class Temp3300 {
    public static void main(String[] args) {
        String keycloakHost = "http://your-keycloak-host";
        String realmName = "your-realm-name";
        String endpoint = keycloakHost + "/auth/admin/realms/" + realmName + "/clients";
        
        System.out.println("POST " + endpoint);
    }
}