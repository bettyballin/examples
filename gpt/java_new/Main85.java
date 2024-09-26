import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.connector.Connector;

public class Main85 {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(9001);
        connector.setXpoweredBy(false);
        connector.setProperty("server", "");
        tomcat.getService().addConnector(connector);
        tomcat.setConnector(connector);
        tomcat.start();
    }
}