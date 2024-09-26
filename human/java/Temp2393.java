public class Temp2393 {
    public static void main(String[] args) {
        System.out.println("<saml:Subject>");
        System.out.println("  <saml:NameID SPNameQualifier=\"http://sp.example.com/demo1/metadata.php\" Format=\"urn:oasis:names:tc:SAML:2.0:nameid-format:transient\">_ce3d2948b4cf20146dee0a0b3dd6f69b6cf86f62d7</saml:NameID>");
        System.out.println("  <saml:SubjectConfirmation Method=\"urn:oasis:names:tc:SAML:2.0:cm:bearer\">");
        System.out.println("    <saml:SubjectConfirmationData NotOnOrAfter=\"2014-07-18T06:21:48Z\" Recipient=\"http://sp.example.com/demo1/index.php?acs\" InResponseTo=\"ONELOGIN_4fee3b046395c4e751011e97f8900b5273d56685\"/>");
        System.out.println("  </saml:SubjectConfirmation>");
        System.out.println("</saml:Subject>");
    }
}