import javax.net.SocketFactory;
import javax.net.ssl.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.util.concurrent.atomic.AtomicReference;

public class MySSLSocketFactory extends SocketFactory {
    private static final AtomicReference<MySSLSocketFactory> defaultFactory = new AtomicReference<>();

    private SSLSocketFactory sf;

    public MySSLSocketFactory() throws Exception {
        KeyStore keyStore = ... /* Get a keystore containing the self-signed certificate */
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(keyStore);
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(null, tmf.getTrustManagers(), null);
        sf = ctx.getSocketFactory();
    }

    public static SocketFactory getDefault() {
        return defaultFactory.updateAndGet(v -> v != null ? v : new MySSLSocketFactory());
    }

    @Override
    public Socket createSocket(String s, int i) throws IOException {
        return sf.createSocket(s, i);
    }

    @Override
    public Socket createSocket(String s, int i, InetAddress inetAddress, int i1) throws IOException {
        return sf.createSocket(s, i, inetAddress, i1);
    }

    @Override
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return sf.createSocket(inetAddress, i);
    }

    @Override
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress1, int i1) throws IOException {
        return sf.createSocket(inetAddress, i, inetAddress1, i1);
    }
}