xml
<!-- This section configures X509 Certificate Authentication -->
<sec:http
        pattern="/service/x509/**"
        use-expressions="true"
        authentication-manager-ref="ldapAuthenticationManager">
    <sec:x509 subject-principal-regex="(.*)" user-service-ref="ldapUserDetailsService" />
    <sec:intercept-url pattern="/service/x509/identity/**" access="hasRole('Domain Users')" />
</sec:http>

<sec:authentication-manager alias="ldapAuthenticationManager">
    <sec:authentication-provider user-service-ref="ldapUserDetailsService" />
</sec:authentication-manager>

<!-- This section configures BASIC Authentication -->
<sec:http
        pattern="/service/basic/**"
        use-expressions="true"
        create-session="stateless"
        authentication-manager-ref="mongoAuthenticationManager">
    <sec:http-basic />
    <sec:intercept-url pattern="/service/basic/identity/**" access="isAuthenticated()" />
</sec:http>

<sec:authentication-manager alias="mongoAuthenticationManager">
    <sec:authentication-provider user-service-ref="mongoUserDetailsService" />
</sec:authentication-manager>

<!-- This section configures NO Authentication -->
<sec:http pattern="/service/anonymous/**" security="none" />