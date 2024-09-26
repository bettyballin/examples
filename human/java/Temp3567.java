public class Temp3567 {
    public static void main(String[] args) {
        Connector connector = new Connector();
        int port = 8080; // Example port number
        connector.setPort(port); 
        connector.setXpoweredBy(false);
        connector.setProperty("server", "");
    }
}

class Connector {
    private int port;
    private boolean xPoweredBy;
    private String serverProperty;

    public void setPort(int port) {
        this.port = port;
    }

    public void setXpoweredBy(boolean xPoweredBy) {
        this.xPoweredBy = xPoweredBy;
    }

    public void setProperty(String key, String value) {
        if ("server".equals(key)) {
            this.serverProperty = value;
        }
    }
}