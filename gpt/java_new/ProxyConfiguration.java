public class ProxyConfiguration {
    public static void main(String[] args) {
        System.setProperty("https.proxyHost", "your-proxy-host");
        System.setProperty("https.proxyPort", "your-proxy-port");
    }
}