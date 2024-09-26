import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class MyUserDetails implements UserDetails {
    private String username;
    private String password;
    private Long id;
    private String email;

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

public class MyUserDetailsService implements UserDetailsService {

    private final DataSource dataSource;

    public MyUserDetailsService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String sql = "SELECT id, email, password FROM users WHERE username=?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            if (!rs.next())
                throw new UsernameNotFoundException("User not found");

            MyUserDetails user = new MyUserDetails();

            // Set the ID and Email fields
            Long id = rs.getLong(1);
            String email = rs.getString(2);
            String password = rs.getString(3);

            user.setId(id);
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(password);

            return user;

        } catch (SQLException e) {
            throw new UsernameNotFoundException("Failed to load user", e);
        }
    }
}