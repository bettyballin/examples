import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String sql = "SELECT * FROM utilisateur WHERE username=?";
        
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[]{username});
        
        if (rows == null || rows.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        
        Map<String, Object> row = rows.get(0);
        String password = row.get("password").toString();
        
        // You can set the roles and authorities as per your requirement
        UserDetails userDetails = User.withUsername(username)
                                      .password(password)
                                      .authorities("USER")
                                      .build();
        
        return userDetails;
    }
}