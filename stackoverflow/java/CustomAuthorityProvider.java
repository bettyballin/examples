import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomAuthorityProvider implements AuthenticationProvider {

    private AuthenticationProvider delegate;
    private JdbcTemplate jdbcTemplate;

    public CustomAuthorityProvider(AuthenticationProvider delegate, DataSource dataSource) {
        this.delegate = delegate;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        final Authentication a = delegate.authenticate(authentication);
        final List<GrantedAuthority> authorities = getGrantedAuthorities(a.getName());
        return new UsernamePasswordAuthenticationToken(a.getPrincipal(), a.getCredentials(), authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return delegate.supports(authentication);
    }

    List<GrantedAuthority> getGrantedAuthorities(String username) {
        return jdbcTemplate.query(
                "SELECT r.Role FROM Users u JOIN UserRole ur ON u.UserId = ur.UserId " +
                "JOIN Roles r ON r.RoleId = ur.RoleId WHERE Username = ?",
                new String[]{username},
                (ResultSet rs, int rowNum) -> new SimpleGrantedAuthority(rs.getString(1))
        );
    }
}