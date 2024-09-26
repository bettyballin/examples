import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService10 implements UserDetailsService {
    
    private final YourSoapClientService soapClientService;
    
    public CustomUserDetailsService10(YourSoapClientService soapClientService) {
        this.soapClientService = soapClientService;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        YourUserDetailsFromSoap userDetailsFromSoap = soapClientService.getUserDetails(username);
        
        List<GrantedAuthority> grantedAuthorities = userDetailsFromSoap.getRoles().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        
        return new User(userDetailsFromSoap.getUsername(), userDetailsFromSoap.getPassword(), grantedAuthorities);
    }
}