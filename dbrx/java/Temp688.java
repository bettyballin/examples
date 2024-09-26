import com.hazelcast.config.Config;
import com.hazelcast.config.ServicesConfig;
import com.hazelcast.config.ServiceConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class Temp688 {
    public static void main(String[] args) {
        Config config = new Config();
        ServicesConfig servicesConfig = config.getServicesConfig();
        servicesConfig.addServiceConfig(
            new ServiceConfig()
                .setEnabled(false)
                .setName("hz:impl:executorService")
        );
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
    }
}