import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MyConnectionProvider implements ConnectionProvider {

    @Autowired
    private DataSource ds;

    @Override
    public Connection acquire() throws DataAccessException {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new DataAccessException("Could not acquire a database connection", e);
        }
    }

    @Override
    public void release(Connection c) throws DataAccessException {
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                throw new DataAccessException("Could not release the database connection", e);
            }
        }
    }
}