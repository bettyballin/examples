import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Temp3185 {

    private BlogUserRepository blogUserRepository;

    @Autowired
    public void setBlogUserRepository(BlogUserRepository blogUserRepository) {
        this.blogUserRepository = blogUserRepository;
    }

    public void authenticateBlogUser(String email, String password) throws UsernameNotFoundException {
        BlogUser user = blogUserRepository.findByEmail(email);
        if (user == null || !user.getPassword().equals(password))
            throw new UsernameNotFoundException("Wrong e-mail and/or password");
        Collection<GrantedAuthority> authorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles)
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getAuth()));
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), authorities));
    }

    public static void main(String[] args) {
        // Example usage
        Temp3185 temp = new Temp3185();
        // Assuming dependency injection or manual setting of blogUserRepository here
        // temp.setBlogUserRepository(...);
        try {
            temp.authenticateBlogUser("user@example.com", "password");
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
        }
    }
}

interface BlogUserRepository {
    BlogUser findByEmail(String email);
}

class BlogUser {
    private String email;
    private String password;
    private Set<Role> roles;

    public BlogUser(String email, String password, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}

class Role {
    private String auth;

    public Role(String auth) {
        this.auth = auth;
    }

    public String getAuth() {
        return auth;
    }
}