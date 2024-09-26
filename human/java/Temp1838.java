import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Temp1838 {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(Temp1838.class, args);
    }
}

@Configuration
class DataSourceConfig {

    @Bean(name = "OAuth")
    @ConfigurationProperties(prefix = "datasource.oauth")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}