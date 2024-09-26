import kafka.admin.AclCommand;

public class KafkaAclExample {
    public static void main(String[] args) {
        String topicName = "example-topic"; // Replace with your topic name
        String[] cmdPArm = {"--add", "--allow-principals", "user:ctadmin", "--operation", "ALL", "--topic", topicName, "--authorizer-properties", "zookeeper.connect=hscale-dev1-dn1:2181,hscale-dev1-dn3:2181,hscale-dev1-dn2:2181"};
        AclCommand.main(cmdPArm);
    }
}