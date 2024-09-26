import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class Temp922 {
    public static void main(String[] args) {

        Config cfg = new Config();
        cfg.setProperty("hazelcast.executor.enabled", "true"); // or false
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);

        // Add some action to keep the instance running
        System.out.println("Hazelcast instance started: " + instance.getName());
    }
}