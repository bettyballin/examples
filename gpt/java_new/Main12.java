import javax.net.ssl.SSLSocket;

public class Main12 {
    public static void main(String[] args) {
        try {
            SSLSocket tempSocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket();
            tempSocket.setEnabledProtocols(new String[] {"TLSv1.2"});
            String[] enabledCipherSuites = {/* list of cipher suites supported by the server */};
            tempSocket.setEnabledCipherSuites(enabledCipherSuites);
            // Additional code to use tempSocket as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}