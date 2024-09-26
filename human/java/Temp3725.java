import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // Simulate Spring Context initialization and bean retrieval
        EnvironmentConfig environmentConfig = new EnvironmentConfig();
        UUID value = environmentConfig.getHomeOrg();
        System.out.println("HomeOrg UUID: " + value);
    }
}

class EnvironmentConfig {
    private UUID homeOrg = UUID.randomUUID();

    public UUID getHomeOrg() {
        return homeOrg;
    }
}