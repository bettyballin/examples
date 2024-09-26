import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.List;
import java.util.stream.Collectors;

public class DatabaseRoleHierarchy implements RoleHierarchy {
    private final JdbcTemplate jdbcTemplate;
    private final RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();

    public DatabaseRoleHierarchy(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        buildRoleHierarchy();
    }

    private void buildRoleHierarchy() {
        String sql = "SELECT child_role, parent_role FROM role_hierarchy";
        List<String> hierarchyStrings = jdbcTemplate.query(sql,
                (rs, rowNum) -> rs.getString("child_role") + " > " + rs.getString("parent_role"));
        String hierarchyStringRepresentation = String.join("
", hierarchyStrings);
        roleHierarchy.setHierarchy(hierarchyStringRepresentation);
    }

    @Override
    public List<GrantedAuthority> getReachableGrantedAuthorities(List<? extends GrantedAuthority> authorities) {
        return roleHierarchy.getReachableGrantedAuthorities(authorities)
                .stream()
                .collect(Collectors.toList());
    }
}