import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp2920 {
    public static void main(String[] args) {
        // Assuming dataSource and clients are defined elsewhere in your application context
        // For demonstration purposes, we'll create a dummy dataSource and clients object
        DataSource dataSource = new DataSource();
        Clients clients = new Clients();

        clients.jdbc(dataSource)
               .passwordEncoder(new BCryptPasswordEncoder());
    }
}

// Dummy classes to make the code executable
class DataSource {
    // Add any necessary methods and properties here
}

class Clients {
    public Clients jdbc(DataSource dataSource) {
        // Simulate jdbc configuration
        System.out.println("Configuring JDBC with dataSource");
        return this;
    }

    public void passwordEncoder(BCryptPasswordEncoder passwordEncoder) {
        // Simulate password encoder configuration
        System.out.println("Configuring password encoder");
    }
}