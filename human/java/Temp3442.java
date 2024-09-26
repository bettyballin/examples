public class Temp3442 {
    public static void main(String[] args) {
        String[] authRoles = new String[1];
        authRoles[0] = "user";

        String[] patterns = new String[1];
        patterns[0] = "/products/*";

        SecurityCollection[] securityCollections = new SecurityCollection[1];
        securityCollections[0] = new SecurityCollection(patterns);

        SecurityConstraint[] securityConstraints = new SecurityConstraint[1];
        securityConstraints[0] = new SecurityConstraint(authRoles, securityCollections);

        KeycloakConfig keycloak = new KeycloakConfig(securityConstraints);

        // Print out to verify
        System.out.println("Auth Roles: " + keycloak.securityConstraints[0].authRoles[0]);
        System.out.println("Patterns: " + keycloak.securityConstraints[0].securityCollections[0].patterns[0]);
    }
}

class SecurityConstraint {
    String[] authRoles;
    SecurityCollection[] securityCollections;

    SecurityConstraint(String[] authRoles, SecurityCollection[] securityCollections) {
        this.authRoles = authRoles;
        this.securityCollections = securityCollections;
    }
}

class SecurityCollection {
    String[] patterns;

    SecurityCollection(String[] patterns) {
        this.patterns = patterns;
    }
}

class KeycloakConfig {
    SecurityConstraint[] securityConstraints;

    KeycloakConfig(SecurityConstraint[] securityConstraints) {
        this.securityConstraints = securityConstraints;
    }
}