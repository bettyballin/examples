import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TerminalUserRepository terminalUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<TerminalUser> user = terminalUserRepo.findByEmailIgnoreCase(username);

        if (!user.isPresent() || !user.get().prop_confirmed())
            throw new UsernameNotFoundException("Invalid email or password.");

        return User
                .withUsername(username)
                .password(user.get().getPassword())
                // Add authorities or roles here if needed
                .authorities("USER") // example authority
                .build();
    }
}

// Assuming TerminalUser and TerminalUserRepository are defined as below:

interface TerminalUserRepository {
    Optional<TerminalUser> findByEmailIgnoreCase(String email);
}

class TerminalUser {
    private String password;
    private boolean prop_confirmed;

    public String getPassword() {
        return password;
    }

    public boolean prop_confirmed() {
        return prop_confirmed;
    }
}