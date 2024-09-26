import org.springframework.context.annotation.Bean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

public class DataSourceConfig {

    @Bean(name = "OAuth")
    @ConfigurationProperties(prefix="datasource.oauth")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}