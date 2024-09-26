import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Temp572 {

    private static JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        // Database connection setup
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/yourdatabase");
        dataSource.setUsername("yourusername");
        dataSource.setPassword("yourpassword");

        jdbcTemplate = new JdbcTemplate(dataSource);

        // Replace with your actual new and old usernames
        String newUsername = "newUser";
        String oldUsername = "oldUser";

        // Update the acl_sid table
        jdbcTemplate.update("update acl_sid set sid = ? where sid = ?", newUsername, oldUsername);

        System.out.println("Update complete");
    }
}