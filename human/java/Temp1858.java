public class Temp1858 {

    public static void main(String[] args) {
        String username = "yourUsername";
        String password = "yourPassword";
        String securityHeader = nodeToString(buildSecurityHeader(username, password));
        System.out.println(securityHeader);
    }

    private static String nodeToString(Object node) {
        // Dummy implementation, adjust as needed
        return node.toString();
    }

    private static Object buildSecurityHeader(String username, String password) {
        // Dummy implementation, adjust as needed
        return "SecurityHeader: {username: " + username + ", password: " + password + "}";
    }
}