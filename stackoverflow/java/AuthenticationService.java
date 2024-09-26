import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {

    private BlogUserRepository blogUserRepository;

    @Autowired
    public void setBlogUserRepository(BlogUserRepository blogUserRepository) {
        this.blogUserRepository = blogUserRepository;
    }

    public void authenticateBlogUser(String email, String password) {
        BlogUser user = blogUserRepository.findByEmail(email);
        if (user == null || !user.getPassword().equals(password))
            throw new UsernameNotFoundException("Wrong e-mail and/or password");

        Collection<GrantedAuthority> authorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles)
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getAuth()));

        SecurityContextHolder.getContext().setAuthentication(
            new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), authorities)
        );
    }
}