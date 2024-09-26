import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

public class Temp281 {

    private JdbcClientDetailsService jdbcClientDetailsService;
    private JdbcTokenStore jdbcTokenStore;

    public static void main(String[] args) {
        Temp281 temp = new Temp281();
        DataSource dataSource = temp.dataSource();
        temp.setDataSource(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/your_database");
        ds.setUsername("your_username");
        ds.setPassword("your_password");

        return ds;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcClientDetailsService = new JdbcClientDetailsService(dataSource);
        jdbcTokenStore = new JdbcTokenStore(dataSource);
    }

}

class JdbcClientDetailsService {
    public JdbcClientDetailsService(DataSource dataSource) {
        // initialization logic here
    }
}

class JdbcTokenStore {
    public JdbcTokenStore(DataSource dataSource) {
        // initialization logic here
    }
}