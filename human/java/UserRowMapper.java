import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EnumSet;
import org.springframework.jdbc.core.RowMapper;

public class User {
    private EnumSet<User_Authority> authorities;

    // Getters and setters for authorities
    public EnumSet<User_Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(EnumSet<User_Authority> authorities) {
        this.authorities = authorities;
    }

    // Other properties, getters, and setters
}

enum User_Authority {
    ROLE_USER("role_user"),
    ROLE_ADMIN("role_admin");

    private final String columnName;

    User_Authority(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }
}

public final class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        // get other columns here
        EnumSet<User_Authority> granted = EnumSet.noneOf(User_Authority.class);
        for (User_Authority auth : User_Authority.values()) {
            if (rs.getInt(auth.getColumnName()) == 1) {
                granted.add(auth);
            }
        }
        user.setAuthorities(granted);
        return user;
    }
}