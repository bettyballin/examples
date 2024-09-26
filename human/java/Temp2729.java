xml
<!-- == Outgoing interceptor == -->
<bean id="loginOutgoingWss4jSecurityInterceptor" class="org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor">
    <property name="securementActions" value="Timestamp Signature Encrypt" />

    <!--  == Set Outgoing Signature properties == -->
    <property name="securementUsername" value="alias"/>
    <property name="securementPassword" value="aliasPass"/>
    <property name="securementSignatureKeyIdentifier" value="DirectReference"/>
    <property name="securementSignatureCrypto" ref="cryptoFactoryBean" />
    <property name="securementSignatureParts" value="{Element}{}Body;{Element}{http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd}Timestamp;" />

    <!--  == Set Outgoing Encryption properties == -->
    <property name="securementEncryptionUser" value="alias"/> 
    <property name="securementEncryptionCrypto" ref="cryptoFactoryBean" />
    <property name="securementEncryptionKeyIdentifier" value="DirectReference"/>
    <property name="securementEncryptionParts" value="{Content}{}Body;" />
</bean>

<!-- == Incoming interceptor == -->
 <bean id="loginIncomingWss4jSecurityInterceptor" class="org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor">
    <property name="validationActions" value="Timestamp Signature Encrypt" />

    <!--  == Set Validations Response, This validate signature and decrypts response == -->
    <property name="validateResponse" value="true" />

    <!-- The lower operation validation. Less time consume-->
    <property name="validateRequest" value="false" />
    <property name="enableSignatureConfirmation" value="false"/>

    <!--  == Set Incoming Signature/Decryption keystore == -->
    <property name="validationDecryptionCrypto" ref="cryptoFactoryBean" />
    <property name="validationSignatureCrypto" ref="cryptoFactoryBean" />

    <!-- Sets the {@link org.apache.ws.security.WSPasswordCallback} handler to use when validating messages -->
    <property name="validationCallbackHandler">
        <bean class="org.springframework.ws.soap.security.wss4j2.callback.KeyStoreCallbackHandler">
            <property name="privateKeyPassword" value="aliasPass"/>
        </bean>
    </property> 
 </bean>