public class Temp1230 {
    public static void main(String[] args) {
        String securityHeader = 
            "<wsse:Security soap:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">" +
                "<wsse:UsernameToken wsu:Id=\"UsernameToken-1\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">" +
                    "<wsse:Username>&lt;YOUR USERNAME&gt;</wsse:Username>" +
                    "<wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">&lt;YOUR PASSWORD&gt;</wsse:Password>" +
                "</wsse:UsernameToken>" +
            "</wsse:Security>";
        
        System.out.println(securityHeader);
    }
}