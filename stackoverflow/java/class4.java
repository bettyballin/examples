import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EnumSet;
import org.springframework.jdbc.core.RowMapper;

public final class4 UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        // get other columns here
        EnumSet<UserAuthority> granted = EnumSet.noneOf(UserAuthority.class4);
        for (UserAuthority auth : UserAuthority.values()) {
            if (rs.getInt(auth.getColumnName()) == 1) {
                granted.add(auth);
            }
        }
        user.setAuthorities(granted);
        return user;
    }
}