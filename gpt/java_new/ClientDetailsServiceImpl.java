import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailsServiceImpl implements UserDetailsService {

    private final ClientDetailsRepository clientDetailsRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public ClientDetailsServiceImpl(ClientDetailsRepository clientDetailsRepository, BCryptPasswordEncoder passwordEncoder) {
        this.clientDetailsRepository = clientDetailsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ClientDetails clientDetails = clientDetailsRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        
        return User.builder()
                .username(clientDetails.getUsername())
                .password(clientDetails.getPassword())
                .authorities(clientDetails.getAuthorities())
                .build();
    }
}