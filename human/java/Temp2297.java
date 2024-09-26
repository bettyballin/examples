import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Temp2297 {
    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new Temp2297().dataSource();
        System.out.println("DataSource initialized: " + dataSource);
    }

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.h2.Driver");
        driverManagerDataSource.setUrl("jdbc:h2:~/test2");
        return driverManagerDataSource;
    }
}