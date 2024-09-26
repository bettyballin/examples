import org.apache.axis2.client.ConfigurationContext;
import org.apache.axis2.client.ConfigurationContextFactory;
import org.apache.axis2.AxisFault;

public class Temp684 {
    public static void main(String[] args) {
        try {
            ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem("path/to/client/repo", null);
            SimpleServiceStub stub = new SimpleServiceStub(ctx, "http://sbswsvm1426ou:9091/axis2/services/SimpleService?wsdl");
            // Add any additional code to interact with the stub here
        } catch (AxisFault e) {
            e.printStackTrace();
        }
    }
}