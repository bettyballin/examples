import java.sql.Connection;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class Temp2352 {
    private static final Logger log = LoggerFactory.getLogger(Temp2352.class);
    private JdbcTemplate jdbcTemplate;

    public Temp2352(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        // Here you would initialize your JdbcTemplate with a DataSource
        // For example: 
        // DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:testdb", "sa", "");
        // JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        
        // Replace the following line with actual initialization
        JdbcTemplate jdbcTemplate = null; 
        
        Temp2352 temp = new Temp2352(jdbcTemplate);
        temp.setConnectionReadOnly(true);
    }

    private void setConnectionReadOnly(boolean readOnly) {
        log.debug("setting JDBC connection to {}", readOnly);
        try {
            Connection con = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            con.setReadOnly(readOnly);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}