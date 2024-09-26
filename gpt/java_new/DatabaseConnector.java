import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private String address;
    private String user_Name;
    private String complete_Password;

    public DatabaseConnector(String address, String user_Name, String complete_Password) {
        this.address = address;
        this.user_Name = user_Name;
        this.complete_Password = complete_Password;
    }

    public Connection connect() {
        String url = "jdbc:mysql://" + address + "/table?useSSL=true&requireSSL=true";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user_Name, complete_Password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
}