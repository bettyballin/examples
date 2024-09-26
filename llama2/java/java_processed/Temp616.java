import org.apache.catalina.startup.Tomcat;

public class Temp616 {
    public static void main(String[] args) {
        Tomcat _tomcat = new Tomcat();
        _tomcat.getConnector().setXpoweredBy(false);
        _tomcat.getConnector().setProperty("server", "");
        _tomcat.getConnector().setPort(9001); // Set the port to 9001
        
        try {
            _tomcat.start();
            _tomcat.getServer().await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}