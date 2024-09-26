public class Temp769 {
    public static void main(String[] args) {
        // Assuming provider and relevant classes are defined elsewhere
        LdapAuthenticationProvider provider = new LdapAuthenticationProvider();

        provider.setUserDetailsContextMapper(new InetOrgPersonContextMapper());
        // or
        provider.setUserDetailsContextMapper(user -> new CustomUserPrincipal(user));
    }
}

// Placeholder class definitions to make the code executable
class LdapAuthenticationProvider {
    public void setUserDetailsContextMapper(InetOrgPersonContextMapper contextMapper) {
        // Implementation here
        System.out.println("InetOrgPersonContextMapper set.");
    }

    public void setUserDetailsContextMapper(CustomUserPrincipalMapper customMapper) {
        // Implementation here
        System.out.println("CustomUserPrincipalMapper set.");
    }
}

class InetOrgPersonContextMapper {
    // Implementation here
}

class CustomUserPrincipal {
    public CustomUserPrincipal(Object user) {
        // Implementation here
    }
}

interface CustomUserPrincipalMapper {
    CustomUserPrincipal map(Object user);
}