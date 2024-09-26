public class Temp3297 {
    public static void main(String[] args) {
        String keycloakHost = "<KEYCLOAK_HOST>";
        String realmName = "<REALM_NAME>";
        String url = String.format("%s/auth/admin/realms/%s/partial-export?exportClients=true&exportGroupsAndRoles=true", keycloakHost, realmName);
        System.out.println("POST " + url);
    }
}