public class Temp1859 {
    public static void main(String[] args) {
        String security = "<wsse:Security xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" soapenv:mustUnderstand=\"1\">" +
                "<wsse:UsernameToken wsu:Id=\"UsernameToken-39dba965-c4a8-4b2d-826e-ade8c0931f3f\">" +
                "<wsse:Username>username</wsse:Username>" +
                "<wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest\">BxJH0G5PzPfBFbBGimF0bq3vjsY=</wsse:Password>" +
                "<wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">iaO1xilL6qfuN2apbSdfPQ==</wsse:Nonce>" +
                "<wsu:Created>2016-06-30T07:17:26.552Z</wsu:Created>" +
                "</wsse:UsernameToken>" +
                "</wsse:Security>";

        System.out.println(security);
    }
}