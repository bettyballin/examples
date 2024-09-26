public class Temp897 {
    public static void main(String[] args) {
        StringBuilder xmlContent = new StringBuilder();
        xmlContent.append("<http use-expressions=\"true\">\n");
        xmlContent.append("    <intercept-url pattern=\"/app/ws**\" access=\"hasRole('ROLE_WEBSERVICE') and hasRole('ROLE_ADMIN')\"/>\n");
        xmlContent.append("    <intercept-url pattern=\"/app**\" access=\"hasRole('ROLE_ADMIN')\"/>\n");
        xmlContent.append("</http>");

        System.out.println(xmlContent.toString());
    }
}