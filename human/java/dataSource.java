package dao;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSource extends DriverManagerDataSource {
    public DataSource() {
        // Set the driver class name
        this.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // Set the URL, username, and password for the database connection
        this.setUrl("jdbc:mysql://localhost:3306/your_database");
        this.setUsername("your_username");
        this.setPassword("your_password");
    }

    public static void main(String[] args) {
        // Create an instance of the DataSource to test the connection
        DataSource dataSource = new DataSource();
        System.out.println("DataSource configured successfully.");
    }
}