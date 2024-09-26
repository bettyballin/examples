import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;
import java.util.stream.Collectors;

public class ExtendedInMemoryUserDetailsManager extends InMemoryUserDetailsManager {

    public ExtendedInMemoryUserDetailsManager(List<UserDetails> users) {
        users.forEach(this::createUser);
    }

    public List<UserDetails> getAllUsers() {
        return this.getUsers().stream().collect(Collectors.toList());
    }
}