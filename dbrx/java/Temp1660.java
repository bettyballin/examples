public class Temp1660 {
    public static void main(String[] args) {
        
        int minPort = 9001;
        int maxPort = 9999;

        for (int i = minPort; i <= maxPort; ++i) {
            try {
                // Assuming _tomcat is an instance of org.apache.catalina.startup.Tomcat
                // Since it's not initialized in the given code, let's initialize it here
                org.apache.catalina.startup.Tomcat _tomcat = new org.apache.catalina.startup.Tomcat();
                
                _tomcat.getConnector().setPort(i);
                break;
            } catch (Exception e) {
                // Handle the exception if needed
            }
        }
    }
}