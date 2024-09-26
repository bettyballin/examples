import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class CustomRoleHierarchyFactory implements RoleHierarchyFactory {

    private final DataSource dataSource;

    @Autowired
    public CustomRoleHierarchyFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public RoleHierarchy createHierarchy() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> roleHierarchyStrings = jdbcTemplate.queryForList("SELECT hierarchy FROM role_hierarchy", String.class);
        
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        for (String hierarchy : roleHierarchyStrings) {
            roleHierarchy.setHierarchy(hierarchy);
        }
        
        return roleHierarchy;
    }
}