import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Temp1149 implements org.springframework.security.core.userdetails.UserDetailsService {

    public static void main(String[] args) {
        // Placeholder for main method logic if needed
    }

    // Assume AccountDAO and Account classes are defined elsewhere
    private AccountDAO accountDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountDAO.findAccount(username);
        System.out.println("Account= " + account);

        if (account == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        String role = account.getUserRole();
        List<GrantedAuthority> grantList = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        grantList.add(authority);

        return org.springframework.security.core.userdetails.User.withUsername(account.getUserName())
                .password(account.getEncrytedPassword())
                .authorities(grantList)
                .accountExpired(false) // or true depending on your requirements
                .accountLocked(false)  // or true depending on your requirements
                .credentialsNonExpired(true) // or false depending on your requirements
                .disabled(!account.isActive()) // invert the active flag to determine if the account is disabled
                .build();
    }
}

// Placeholder for AccountDAO and Account classes for completeness
class AccountDAO {
    public Account findAccount(String username) {
        // Placeholder for actual database fetch logic
        return new Account(username, "encryptedPassword", "ROLE_USER", true);
    }
}

class Account {
    private String userName;
    private String encrytedPassword;
    private String userRole;
    private boolean active;

    public Account(String userName, String encrytedPassword, String userRole, boolean active) {
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
        this.userRole = userRole;
        this.active = active;
    }

    public String getUserName() {
        return userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", encrytedPassword='" + encrytedPassword + '\'' +
                ", userRole='" + userRole + '\'' +
                ", active=" + active +
                '}';
    }
}