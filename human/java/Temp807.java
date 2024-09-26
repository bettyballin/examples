import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Temp807 {
    public static void main(String[] args) {
        try {
            InitialContext initialContext = new InitialContext();
            DataSource datasource = (DataSource) initialContext.lookup("jdbc/MyJDBCRealm");
            System.out.println("DataSource retrieved successfully: " + datasource);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}