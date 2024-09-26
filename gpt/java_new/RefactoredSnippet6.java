import org.eclipse.jetty.server.ConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import javax.net.ssl.SSLContext;

public class RefactoredSnippet6 {

    // Assume this method exists and is correctly implemented.
    private static SSLContext createNewSSLContextWithUpdatedStores() {
        // ... implementation ...
        return null;
    }

    public static void main(String[] args) {
        Server server = new Server();
        SSLContext newSSLContext = createNewSSLContextWithUpdatedStores();

        for (Connector connector : server.getConnectors()) {
            if (connector instanceof ServerConnector) {
                ServerConnector serverConnector = (ServerConnector) connector;
                ConnectionFactory connectionFactory = serverConnector.getDefaultConnectionFactory();
                
                if (connectionFactory instanceof SslConnectionFactory) {
                    SslConnectionFactory sslConnectionFactory = (SslConnectionFactory) connectionFactory;
                    SslContextFactory sslContextFactory = sslConnectionFactory.getSslContextFactory();
                    sslContextFactory.setSslContext(newSSLContext);
                }
            }
        }
    }
}