import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class MyConnectionProvider implements ConnectionProvider {

    @Autowired
    private DataSource ds;

    @Override
    public Connection acquire() {
        try {
            Connection c = ds.getConnection();
            // Do your stuff here
            return c;
        } catch (SQLException e) {
            throw new DataAccessException("Something failed", e);
        }
    }

    @Override
    public void release(Connection c) {
        try {
            // Do your stuff here
            c.close();
        } catch (SQLException e) {
            throw new DataAccessException("Something failed", e);
        }
    }

    public static void main(String[] args) {
        // Just to make the class executable, although connection handling is usually managed by the application context
        MyConnectionProvider provider = new MyConnectionProvider();
        // You would typically not manually use the provider like this
    }
}

interface ConnectionProvider {
    Connection acquire();
    void release(Connection c);
}

class DataAccessException extends RuntimeException {
    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}