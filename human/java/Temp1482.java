public class Temp1482 {
    public static void main(String[] args) {
        System.out.println("Spring Security configuration cannot be executed directly as Java code.");
        System.out.println("Please integrate the following XML configuration into your Spring and Mule ESB application:");
        System.out.println("");
        System.out.println("<spring:beans>");
        System.out.println("    <ss:authentication-manager alias=\"authenticationManager\">");
        System.out.println("        <ss:authentication-provider>");
        System.out.println("            <ss:user-service id=\"userService\">");
        System.out.println("                <ss:user name=\"john\" password=\"abc123\" authorities=\"ROLE_ADMIN\" />");
        System.out.println("                <ss:user name=\"anon\" password=\"anon\" authorities=\"ROLE_ANON\" />");
        System.out.println("            </ss:user-service>");
        System.out.println("        </ss:authentication-provider>");
        System.out.println("    </ss:authentication-manager>");
        System.out.println("</spring:beans>");
        System.out.println("");
        System.out.println("<mule-ss:security-manager>");
        System.out.println("    <mule-ss:delegate-security-provider name=\"memory-provider\" delegate-ref=\"authenticationManager\" />");
        System.out.println("</mule-ss:security-manager>");
        System.out.println("");
        System.out.println("<http:listener-config name=\"HTTP_Listener_Configuration\" host=\"localhost\" port=\"8081\" doc:name=\"HTTP Listener Configuration\" />");
        System.out.println("");
        System.out.println("<flow name=\"SpringExampleFlow\">");
        System.out.println("    <http:listener config-ref=\"HTTP_Listener_Configuration\" path=\"/\" doc:name=\"HTTP\" />");
        System.out.println("    <http:basic-security-filter realm=\"mule-realm\" />");
        System.out.println("    <logger level=\"INFO\" message=\"passed security successfully !!!\" doc:name=\"Logger\" />");
        System.out.println("</flow>");
        System.out.println("</mule>");
    }
}