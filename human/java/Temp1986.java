public class Temp1986 {
    public static void main(String[] args) {
        System.out.println("Define a SSL Coyote HTTP/1.1 Connector on port 8443");
        System.out.println("<Connector");
        System.out.println("    protocol=\"org.apache.coyote.http11.Http11NioProtocol\"");
        System.out.println("    port=\"8443\" maxThreads=\"200\"");
        System.out.println("    scheme=\"https\" secure=\"true\" SSLEnabled=\"true\"");
        System.out.println("    keystoreFile=\"${user.home}/.keystore\" keystorePass=\"changeit\"");
        System.out.println("    clientAuth=\"false\" sslProtocol=\"TLS\"/>");
    }
}