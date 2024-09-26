import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

public class CustomUserDetails extends User {

    private final String companyName;
    private final Long companyId;

    public CustomUserDetails(String username, String password, Collection authorities,
                             String companyName, Long companyId) {
        super(username, password, authorities);
        this.companyName = companyName;
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Long getCompanyId() {
        return companyId;
    }
}

public class CustomUserDetailsService implements UserDetailsService {
    
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new CustomUserDetails(
            userEntity.getUsername(),
            userEntity.getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority(userEntity.getRole())),
            userEntity.getCompanyName(),
            userEntity.getCompanyId()
        );
    }
}