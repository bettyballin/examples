public class Temp2428 {
    public static void main(String[] args) {
        String http = "<http>\n" +
                "    <intercept-url pattern=\"/admin*\"\n" +
                "        access=\"hasRole('admin') and hasIpAddress('192.168.1.0/24')\"/>\n" +
                "    ...\n" +
                "</http>";

        System.out.println(http);
    }
}