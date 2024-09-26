import java.util.UUID;

public class Temp2644 {
    public static void main(String[] args) {
        Temp2644 temp = new Temp2644();
        System.out.println(temp.hasHomeOrg());
    }

    public final String hasHomeOrg() {
        UUID homeOrg = AppContext.getBean(EnvironmentConfig.class).getHomeOrg();
        // Your authorization logic here
        return homeOrg != null ? homeOrg.toString() : "No HomeOrg found";
    }
}

class AppContext {
    public static <T> T getBean(Class<T> clazz) {
        // Mock implementation for example purposes
        return clazz.cast(new EnvironmentConfig());
    }
}

class EnvironmentConfig {
    public UUID getHomeOrg() {
        // Mock implementation for example purposes
        return UUID.randomUUID();
    }
}