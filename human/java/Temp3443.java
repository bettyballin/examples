public class Temp3443 {
    public static void main(String[] args) {
        Keycloak keycloak = new Keycloak();

        keycloak.securityConstraints[0].authRoles[0] = "admin";
        keycloak.securityConstraints[0].authRoles[1] = "user";
        keycloak.securityConstraints[0].securityCollections[0].name = "insecure stuff";
        keycloak.securityConstraints[0].securityCollections[0].patterns[0] = "/insecure";

        keycloak.securityConstraints[1].authRoles[0] = "admin";
        keycloak.securityConstraints[1].securityCollections[0].name = "admin stuff";
        keycloak.securityConstraints[1].securityCollections[0].patterns[0] = "/admin";
    }
}

class Keycloak {
    SecurityConstraint[] securityConstraints = {
            new SecurityConstraint(),
            new SecurityConstraint()
    };
}

class SecurityConstraint {
    String[] authRoles = new String[2];
    SecurityCollection[] securityCollections = {new SecurityCollection()};
}

class SecurityCollection {
    String name;
    String[] patterns = new String[1];
}