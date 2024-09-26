public class Temp1525 {
    public static void main(String[] args) {
        String xmlContent = """
        <md:EntityDescriptor entityID="https://mysp.example.com/shibboleth-sp" xmlns:md="urn:oasis:names:tc:SAML:2.0:metadata">
            <md:SPSSODescriptor protocolSupportEnumeration="urn:oasis:names:tc:SAML:1.1:protocol urn:oasis:names:tc:SAML:2.0:protocol" xmlns:md="urn:oasis:names:tc:SAML:2.0:metadata">
                <md:KeyDescriptor use="signing">
                    <ds:KeyInfo xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
                        <ds:KeyName>mysp.example.com</ds:KeyName>
                        <ds:X509Data>
                            <ds:X509Certificate xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
                                REPLACE_ENTITY_ID_AND_ACS_URL_AND_PUT_YOUR_CERTIFICATE_HERE
                            </ds:X509Certificate>
                        </ds:X509Data>
                    </ds:KeyInfo>
                </md:KeyDescriptor>
                <md:KeyDescriptor use="encryption">
                    <ds:KeyInfo xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
                        <ds:KeyName>mysp.example.com</ds:KeyName>
                        <ds:X509Data>
                            <ds:X509Certificate xmlns:ds="http://www.w3.org/2000/09/xmldsig#">
                                REPLACE_ENTITY_ID_AND_ACS_URL_AND_PUT_YOUR_CERTIFICATE_HERE
                            </ds:X509Certificate>
                        </ds:X509Data>
                    </ds:KeyInfo>
                </md:KeyDescriptor>
                <md:AssertionConsumerService Binding="urn:oasis:names:tc:SAML:2.0:bindings:HTTP-POST" Location="http://mysp.example.com/shibboleth/Shibboleth.sso/SAML2/POST" index="1"/>
                <md:AssertionConsumerService Binding="urn:oasis:names:tc:SAML:2.0:bindings:HTTP-Artifact" Location="http://mysp.example.com/shibboleth/Shibboleth.sso/SAML2/Artifact" index="2"/>
                <md:AssertionConsumerService Binding="urn:oasis:names:tc:SAML:1.0:profiles:artifact-01" Location="http://mysp.example.com/shibboleth/Shibboleth.sso/SAML/Artifact" index="3"/>
                <md:AssertionConsumerService Binding="urn:oasis:names:tc:SAML:1.0:profiles:browser-post" Location="http://mysp.example.com/shibboleth/Shibboleth.sso/SAML/POST" index="4"/>
            </md:SPSSODescriptor>
        </md:EntityDescriptor>
        """;

        System.out.println(xmlContent);
    }
}