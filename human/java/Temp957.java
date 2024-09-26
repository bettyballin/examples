import com.jolbox.bonecp.BoneCPDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;

public class Temp957 {
    public static void main(String[] args) {
        Temp957 temp = new Temp957();
        DataSource ds = temp.dataSource();
        System.out.println("DataSource has been initialized: " + ds);
    }

    @Bean
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();

        dataSource.setDriverClass("org.postgresql.Driver");
        dataSource.setJdbcUrl("jdbc:postgresql://localhost/oauthDB");
        dataSource.setUsername("my_username");
        dataSource.setPassword("*****");

        return dataSource;
    }
}