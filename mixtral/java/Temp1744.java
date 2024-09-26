import java.util.List;

public class Temp1744 {

    // Mock Authentication class
    static class Authentication {
        private List<Authority> authorities;

        public Authentication(List<Authority> authorities) {
            this.authorities = authorities;
        }

        public List<Authority> getAuthorities() {
            return authorities;
        }
    }

    // Mock Authority class
    static class Authority {
        private String authority;

        public Authority(String authority) {
            this.authority = authority;
        }

        public String getAuthority() {
            return authority;
        }
    }

    public static void main(String[] args) {
        // Mock data
        List<Authority> authorities = List.of(new Authority("ROLE_USER"), new Authority("ROLE_ADMIN"));
        Authentication authentication = new Authentication(authorities);

        // Check if user has ROLE_ADMIN
        if (authentication.getAuthorities().stream().anyMatch(a -> "ROLE_ADMIN".equalsIgnoreCase(a.getAuthority()))) {
            System.out.println("User has ROLE_ADMIN");
        }

        // Alternative way to check if user has ROLE_ADMIN
        boolean isAdmin = authentication.getAuthorities().stream().anyMatch(a -> "ROLE_ADMIN".equalsIgnoreCase(a.getAuthority()));
        if (isAdmin) {
            System.out.println("User is an admin");
        }
    }
}