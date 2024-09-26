import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

public class CustomService implements UserDetailsService {

    private AccountDAO accountDAO;
    private CompanyDAO companyDAO;

    public CustomService(AccountDAO accountDAO, CompanyDAO companyDAO) {
        this.accountDAO = accountDAO;
        this.companyDAO = companyDAO;
    }

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {

        Account account = accountDAO.findAccountByName(username);

        if (account == null) {
            throw new UsernameNotFoundException("account name not found");
        }
        return buildUserFromAccount(account);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    private User buildUserFromAccount(Account account) {

        String username = account.getUsername();
        String password = account.getPassword();
        boolean enabled = account.getEnabled();
        boolean accountNonExpired = account.getAccountNonExpired();
        boolean credentialsNonExpired = account.getCredentialsNonExpired();
        boolean accountNonLocked = account.getAccountNonLocked();

        // additional information goes here
        String companyName = companyDAO.getCompanyName(account);

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : account.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        CustomUserDetails user = new CustomUserDetails(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
                authorities, companyName);

        return user;
    }

    public static class CustomUserDetails extends User {

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

    // Dummy classes to make the example self-contained
    public static class Account {
        private String username;
        private String password;
        private boolean enabled;
        private boolean accountNonExpired;
        private boolean credentialsNonExpired;
        private boolean accountNonLocked;
        private Collection<Role> roles;

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public boolean getEnabled() {
            return enabled;
        }

        public boolean getAccountNonExpired() {
            return accountNonExpired;
        }

        public boolean getCredentialsNonExpired() {
            return credentialsNonExpired;
        }

        public boolean getAccountNonLocked() {
            return accountNonLocked;
        }

        public Collection<Role> getRoles() {
            return roles;
        }
    }

    public static class Role {
        private String name;

        public String getName() {
            return name;
        }
    }

    public static class AccountDAO {
        public Account findAccountByName(String name) {
            // Dummy implementation
            return null;
        }
    }

    public static class CompanyDAO {
        public String getCompanyName(Account account) {
            // Dummy implementation
            return null;
        }
    }
}