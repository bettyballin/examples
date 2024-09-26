import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.DelegatingConnection;
import org.springframework.jdbc.datasource.SmartDataSource;

public class SessionVariableDataSource implements SmartDataSource {
    private final HikariDataSource dataSource;

    public SessionVariableDataSource(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        try {
            Connection connection = this.dataSource.getConnection();
            // Set session variable here

            return new DelegatingConnection(connection) {
                @Override
                protected void finalize() throws Throwable {
                    super.finalize();

                    // Unset the session variables before closing

                    close();
                }

                public Connection getInnermostDelegate() {
                    return connection;
                }
            };
        } catch (SQLException e) {
            throw new SQLException("Failed to acquire a database connection", e);
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        throw new UnsupportedOperationException("This DataSource does not support this method.");
    }

    public static void main(String[] args) {
        // Example usage
        HikariDataSource hikariDataSource = new HikariDataSource();
        // Configure HikariDataSource as needed
        SessionVariableDataSource sessionVariableDataSource = new SessionVariableDataSource(hikariDataSource);

        try {
            Connection connection = sessionVariableDataSource.getConnection();
            // Use the connection
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}