import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Temp125 {
    public static void main(String[] args) {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setSslProtocol("TLSv1");
        ds.setUser("yourUsername"); // replace with your actual username
        ds.setPassword("yourPassword"); // replace with your actual password
        ds.setServerName("yourServerName"); // replace with your actual server name
        ds.setDatabaseName("yourDatabaseName"); // replace with your actual database name

        try (Connection conn = ds.getConnection()) {
            System.out.println("Connection established successfully.");
            // Your database operations here
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}