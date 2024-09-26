import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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

    public Authentication authenticate(Authentication authentication) {

        final Authentication a = delegate.authenticate(authentication);

        // Load additional authorities and create an Authentication object
        final List<GrantedAuthority> authorities = getGrantedAuthorities(a.getName());

        return new UsernamePasswordAuthenticationToken(a.getPrincipal(), a.getCredentials(), authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return delegate.supports(authentication);
    }

    List<GrantedAuthority> getGrantedAuthorities(String username) {
        List<GrantedAuthority> roles = jdbcTemplate.query("select r.Role from Users u join UserRole ur on u.UserId = "
                        + "ur.UserId join Roles r on r.RoleId = ur.RoleId where Username = ?",
                new Object[]{username},
                new RowMapper<GrantedAuthority>() {
                    public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new SimpleGrantedAuthority(rs.getString(1));
                    }
                });
        return roles;
    }
}