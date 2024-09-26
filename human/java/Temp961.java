public class Temp961 {
    public static void main(String[] args) {
        String soapMessage =
                "<s:Envelope xmlns:s=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:a=\"http://www.w3.org/2005/08/addressing\" xmlns:u=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">" +
                "<s:Header>" +
                "<a:Action s:mustUnderstand=\"1\">http://schemas.xmlsoap.org/ws/2005/02/trust/RST/Issue</a:Action>" +
                "<a:MessageID>urn:uuid:{GENERATE-GUID-HERE}</a:MessageID>" +
                "<a:ReplyTo>" +
                "<a:Address>http://www.w3.org/2005/08/addressing/anonymous</a:Address>" +
                "</a:ReplyTo>" +
                "<VsDebuggerCausalityData xmlns=\"http://schemas.microsoft.com/vstudio/diagnostics/servicemodelsink\">uIDPo4TBVw9fIMZFmc7ZFxBXIcYAAAAAbd1LF/fnfUOzaja8sGev0GKsBdINtR5Jt13WPsZ9dPgACQAA</VsDebuggerCausalityData>" +
                "<a:To s:mustUnderstand=\"1\">https://login.microsoftonline.com/RST2.srf </a:To>" +
                "<o:Security s:mustUnderstand=\"1\" xmlns:o=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">" +
                "<u:Timestamp u:Id=\"_0\">" +
                "<u:Created>{UTC-TIMESTAMP}</u:Created>" +
                "<u:Expires>{UTC-TIMESTAMP}</u:Expires>" +
                "</u:Timestamp>" +
                "<o:UsernameToken u:Id=\"uuid-14bed392-2320-44ae-859d-fa4ec83df57a-1\">" +
                "<o:Username>{CLOUD-USERNAME}</o:Username>" +
                "<o:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">{CLOUD-PASSWORD}</o:Password>" +
                "</o:UsernameToken>" +
                "</o:Security>" +
                "</s:Header>" +
                "<s:Body>" +
                "<t:RequestSecurityToken xmlns:t=\"http://schemas.xmlsoap.org/ws/2005/02/trust\">" +
                "<wsp:AppliesTo xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\">" +
                "<a:EndpointReference>" +
                "<a:Address>urn:crmna:dynamics.com</a:Address>" +
                "</a:EndpointReference>" +
                "</wsp:AppliesTo>" +
                "<t:RequestType>http://schemas.xmlsoap.org/ws/2005/02/trust/Issue</t:RequestType>" +
                "</t:RequestSecurityToken>" +
                "</s:Body>" +
                "</s:Envelope>";

        System.out.println(soapMessage);
    }
}