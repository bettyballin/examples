import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSource extends DriverManagerDataSource {
    public DataSource() {
        super();
        this.setDriverClassName("com.mysql.jdbc.Driver");
        this.setUrl("jdbc:mysql://.../.....");
        this.setUsername("");
        this.setPassword("");
    }
}