public class Temp2942 {
    public static void main(String[] args) {
        String httpsProxyHost = System.getProperty("https.proxyHost");
        String httpsProxyPort = System.getProperty("https.proxyPort");
        String httpNonProxyHosts = System.getProperty("http.nonProxyHosts");

        System.out.println("https.proxyHost: " + httpsProxyHost);
        System.out.println("https.proxyPort: " + httpsProxyPort);
        System.out.println("http.nonProxyHosts: " + httpNonProxyHosts);
    }
}