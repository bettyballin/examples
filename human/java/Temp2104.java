import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Temp2104 {
    public static void main(String[] args) {
        // Create a DataSource
        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:testdb", "sa", "");
        
        // Initialize JdbcClientDetailsService with the DataSource
        JdbcClientDetailsService jdbcClientDetailsService = new JdbcClientDetailsService(dataSource);
        
        System.out.println("JdbcClientDetailsService initialized successfully!");
    }
}