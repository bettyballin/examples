import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class AdminUserDetailsService implements UserDetailsService {
    
    // Inject your admin repository here
    // @Autowired
    // private AdminRepository adminRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implement your logic to load an admin by username
        throw new UsernameNotFoundException("Admin not found with username: " + username);
    }
}

@Service
public class CommonUserDetailsService implements UserDetailsService {
    
    // Inject your common user repository here
    // @Autowired
    // private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implement your logic to load a common user by username
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}