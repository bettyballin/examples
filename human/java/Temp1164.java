import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

public class Temp1164 {

    public static void main(String[] args) {
        DataSource ds = dataSource();
        // You can now use the DataSource ds
    }

    public static DataSource dataSource() {
        PoolProperties p = new PoolProperties();
        p.setUrl(Settings.getInstance().config.database.url + "?useUnicode=true&characterEncoding=UTF-8");
        p.setDriverClassName(Settings.getInstance().config.database.driver);
        p.setUsername(Settings.getInstance().config.database.user);
        p.setPassword(Settings.getInstance().config.database.password);
        p.setJmxEnabled(false);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
                        + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer;"
                        + "org.apache.tomcat.jdbc.pool.interceptor.ResetAbandonedTimer");
        DataSource ds = new DataSource();
        ds.setPoolProperties(p);
        return ds;
    }
}

class Settings {
    public Config config;

    private static Settings instance = new Settings();

    private Settings() {
        // Initialize your settings here
        config = new Config();
    }

    public static Settings getInstance() {
        return instance;
    }

    class Config {
        public Database database = new Database();

        class Database {
            public String url = "jdbc:mysql://localhost:3306/mydb";
            public String driver = "com.mysql.cj.jdbc.Driver";
            public String user = "root";
            public String password = "password";
        }
    }
}