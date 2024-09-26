import org.apache.catalina.connector.Connector;

public class ConnectorSetup {
    public static void main(String[] args) {
        int port = 8080; // Example port, replace with actual port number as needed
        Connector connector = new Connector();
        connector.setPort(port);
        connector.setXpoweredBy(false);
        connector.setProperty("server", "");
    }
}