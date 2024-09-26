public class Temp2126 {
    public static void main(String[] args) {
        System.out.println("<oauth:authorization-server client-details-service-ref=\"clientDetails\" token-services-ref=\"tokenServices\" user-approval-handler-ref=\"userApprovalHandler\" request-validator-ref=\"myOAuth2RequestValidator\">");
        System.out.println("    <oauth:authorization-code />");
        System.out.println("    <oauth:implicit />");
        System.out.println("    <oauth:refresh-token />");
        System.out.println("    <oauth:client-credentials />");
        System.out.println("    <oauth:password />");
        System.out.println("</oauth:authorization-server>");
    }
}