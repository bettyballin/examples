import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Sample usage
        Authentication authentication = new Authentication();
        authentication.addAuthority(new Role(true)); // Adding a role that can show suppliers
        
        AuthorityChecker authorityChecker = new AuthorityChecker();
        System.out.println("Can show suppliers: " + authorityChecker.canShowSuppliers(authentication));
    }
}

class AuthorityChecker {

    public boolean canShowSuppliers(Authentication authentication) {
        for (Authority authority : authentication.getAuthorities()) {
            if (authority instanceof Role) {
                Role role = (Role) authority; // cast to Role
                if (role.isShowSuppliers()) {
                    return true;
                }
            }
        }
        return false;
    }
}

interface Authority {
    // Other methods can be defined here
}

class Role implements Authority {
    private boolean showSuppliers;

    public Role(boolean showSuppliers) {
        this.showSuppliers = showSuppliers;
    }

    public boolean isShowSuppliers() {
        return showSuppliers;
    }
}

class Authentication {
    private List<Authority> authorities;

    public Authentication() {
        this.authorities = new java.util.ArrayList<>();
    }

    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }
}