import java.util.Properties;

public class Temp921 {
    public static void main(String[] args) {
        Config cfg = new Config();
        cfg.getProperties().setProperty("hazelcast.executor.enabled", "false");
    }
}

class Config {
    private Properties properties = new Properties();

    public Properties getProperties() {
        return properties;
    }
}