public class Temp2078 {
    public static void main(String[] args) {
        String wsdl = """
            <?xml version="1.0" encoding="UTF-8"?>
            <wsdl:definitions xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy" xmlns:sp="http://docs.oasis-open.org/ws-sx/ws-securitypolicy/200702" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:wsaw="http://www.w3.org/2006/05/addressing/wsdl" xmlns:wsdlsoap="http://schemas.xmlsoap.org/wsdl/soap/">
            
            <wsdl:binding name="..." type="...">
                <wsaw:UsingAddressing wsdl:required="false"/>
                <wsdlsoap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http"/>
                
                <!-- added to wsdl for encryption -->
                <wsp:PolicyReference URI="#general_policy"/>
                
                <wsdl:operation name="xxx">
                    <wsdlsoap:operation soapAction=""/>
                    <wsdl:input name="...">
                        <!-- added to wsdl for encryption -->
                        <wsp:PolicyReference URI="#xxx_policy"/>
                        <wsdlsoap:body use="literal"/>
                    </wsdl:input>
                    <wsdl:output name="..."/>
                </wsdl:operation>
            </wsdl:binding>
            
            <!-- added to wsdl for encryption -->
            
            <wsp:Policy wsu:Id="general_policy">
                <wsp:ExactlyOne>
                    <wsp:Policy>
                        <wsp:All>
                            <sp:AsymmetricBinding>
                                <wsp:Policy>
                                    <sp:InitiatorToken>
                                        <wsp:Policy>
                                            <sp:X509Token sp:IncludeToken="http://docs.oasis-open.org/ws-sx/ws-securitypolicy/200702/IncludeToken/Never">
                                                <wsp:Policy>
                                                    <sp:WssX509V3Token10/>
                                                </wsp:Policy>
                                            </sp:X509Token>
                                        </wsp:Policy>
                                    </sp:InitiatorToken>
                                    <sp:RecipientToken>
                                        <wsp:Policy>
                                            <sp:X509Token sp:IncludeToken="http://docs.oasis-open.org/ws-sx/ws-securitypolicy/200702/IncludeToken/Never">
                                                <wsp:Policy>
                                                    <sp:WssX509V3Token10/>
                                                </wsp:Policy>
                                            </sp:X509Token>
                                        </wsp:Policy>
                                    </sp:RecipientToken>
                                    <sp:Layout>
                                        <wsp:Policy>
                                            <sp:Strict/>
                                        </wsp:Policy>
                                    </sp:Layout>
                                    <sp:AlgorithmSuite>
                                        <wsp:Policy>
                                            <sp:Basic256/>
                                        </wsp:Policy>
                                    </sp:AlgorithmSuite>
                                </wsp:Policy>
                            </sp:AsymmetricBinding>
                        </wsp:All>
                    </wsp:Policy>
                </wsp:ExactlyOne>
            </wsp:Policy>
            
            <wsp:Policy wsu:Id="xxx_policy">
                <wsp:ExactlyOne>
                    <wsp:All>
                        <sp:ContentEncryptedElements>
                            <sp:XPath>/*[namespace-uri()='http://schemas.xmlsoap.org/soap/envelope/' and local-name()='Envelope']/*[namespace-uri()='http://schemas.xmlsoap.org/soap/envelope/' and local-name()='Body']/*[namespace-uri()='xxx' and local-name()='xxxRequest']/yyy</sp:XPath>
                        </sp:ContentEncryptedElements>
                    </wsp:All>
                </wsp:ExactlyOne>
            </wsp:Policy>
            </wsdl:definitions>
        """;
        
        System.out.println(wsdl);
    }
}