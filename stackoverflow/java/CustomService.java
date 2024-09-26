import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;
import java.util.ArrayList;

public class CustomService implements UserDetailsService {

    private AccountDAO accountDAO; // Assume this DAO is defined somewhere
    private CompanyDAO companyDAO; // Assume this DAO is defined somewhere

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Account account = accountDAO.findAccountByName(username);
        if (account == null) {
            throw new UsernameNotFoundException("account name not found");
        }
        return buildUserFromAccount(account);
    }

    @Transactional(readOnly = true)
    private User buildUserFromAccount(Account account) {
        String username = account.getUsername();
        String password = account.getPassword();
        boolean enabled = account.getEnabled();
        boolean accountNonExpired = account.getAccountNonExpired();
        boolean credentialsNonExpired = account.getCredentialsNonExpired();
        boolean accountNonLocked = account.getAccountNonLocked();
        String companyName = companyDAO.getCompanyName(account);

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : account.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new CustomUserDetails(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, companyName);
    }

    public class CustomUserDetails extends User {
        private String company;

        public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
                                 boolean credentialsNonExpired, boolean accountNonLocked,
                                 Collection<? extends GrantedAuthority> authorities, String company) {
            super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
            this.company = company;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }
    }

    // Additional classes and interfaces assumed to be defined elsewhere:
    // - Account
    // - AccountDAO
    // - CompanyDAO
    // - Role
    
    // Getters and setters for accountDAO and companyDAO should be implemented
}