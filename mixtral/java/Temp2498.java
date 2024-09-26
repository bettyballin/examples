public class Temp2498 {
    public static void main(String[] args) {
        Connector connector = new Connector();
        connector.setProtocol("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(9001);
        // Add other required configurations here
    }
}

class Connector {
    private String protocol;
    private int port;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}