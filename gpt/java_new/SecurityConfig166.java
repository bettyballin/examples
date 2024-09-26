import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.util.List;

public class SecurityConfig166 {
    private List<SimpleGrantedAuthority> roleList = new ArrayList<>();

    public void addAdminRole() {
        roleList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/admin*").hasRole("ADMIN");
    }
}