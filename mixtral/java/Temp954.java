import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.KafkaAdminClient;

import java.util.Properties;

public class Temp954 {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "{bootstrap-servers}");
        // Add Kerberos configuration properties
        props.put("security.protocol", "SASL_PLAINTEXT");
        props.put("sasl.mechanism", "GSSAPI");
        props.put("sasl.kerberos.service.name", "{kafka-principal}");

        KafkaAdminClient admin = (KafkaAdminClient) KafkaAdminClient.create(props);
    }
}