import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateUsername(String newUsername, String oldUsername) {
        jdbcTemplate.update("update acl_sid set sid = ? where sid = ?", newUsername, oldUsername);
    }
}