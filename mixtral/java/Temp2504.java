public class Temp2504 {
    public static void main(String[] args) {

        System.setProperty("http.proxyHost", "your_proxy_host");
        System.setProperty("http.proxyPort", "your_proxy_port");

        // If authentication is required
        System.setProperty("https.proxyUser", "username");
        System.setProperty("https.proxyPassword", "password");

    }
}