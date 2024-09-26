xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xmlns:security="http://www.springframework.org/schema/security"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
        http://www.springframework.org/schema/security http://www.springframework.org/schema/security/spring-security-3.2.xsd">

    <bean id="expressionHandler" class="org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler">
        <property name="permissionEvaluator" ref="permissionEvaluator" />
    </bean>

    <!-- We'll rely on the standard AclPermissionEvaluator  implementation -->
    <bean class="org.springframework.security.acls.AclPermissionEvaluator" id="permissionEvaluator">
        <constructor-arg ref="aclService" />
        <property name="sidRetrievalStrategy" ref="sidRetrievalStrategy" />
        <property name="permissionFactory" ref="permissionFactory"/>
    </bean>

    <bean class="org.springframework.security.acls.domain.SidRetrievalStrategyImpl" id="sidRetrievalStrategy">
        <constructor-arg ref="roleHierarchy" />
    </bean>

    <!-- Declare an acl service -->
    <bean class="org.springframework.security.acls.jdbc.JdbcMutableAclService" id="aclService">
        <constructor-arg ref="dataSource" />
        <constructor-arg ref="lookupStrategy" />
        <constructor-arg ref="aclCache" />
        <property name="classIdentityQuery" value="select currval(pg_get_serial_sequence('acl_class', 'id'))" />
        <property name="sidIdentityQuery" value="select currval(pg_get_serial_sequence('acl_sid', 'id'))" />
    </bean>

    <!-- Declare a lookup strategy -->
    <bean id="lookupStrategy" class="org.springframework.security.acls.jdbc.BasicLookupStrategy">
        <constructor-arg ref="dataSource" />
        <constructor-arg ref="aclCache" />
        <constructor-arg ref="aclAuthorizationStrategy" />
        <constructor-arg ref="permissionGrantingStrategy" />
        <property name="permissionFactory" ref="permissionFactory"/>
    </bean>

    <bean id="permissionFactory" class="org.springframework.security.acls.domain.DefaultPermissionFactory" />

    <!-- Declare an acl cache -->
    <bean id="aclCache" class="org.springframework.security.acls.domain.SpringCacheBasedAclCache">
        <constructor-arg>
            <bean class="com.example.NoOpCache">
                <constructor-arg value="aclCache" />
            </bean>
        </constructor-arg>
        <constructor-arg ref="permissionGrantingStrategy" />
        <constructor-arg ref="aclAuthorizationStrategy" />
    </bean>

    <!-- Declare an acl authorization strategy -->
    <bean id="aclAuthorizationStrategy" class="org.springframework.security.acls.domain.AclAuthorizationStrategyImpl">
        <constructor-arg>
            <list>
                <bean class="org.springframework.security.core.authority.SimpleGrantedAuthority">
                    <constructor-arg value="ROLE_ADMIN" />
                </bean>
                <bean class="org.springframework.security.core.authority.SimpleGrantedAuthority">
                    <constructor-arg value="ROLE_ADMIN" />
                </bean>
                <bean class="org.springframework.security.core.authority.SimpleGrantedAuthority">
                    <constructor-arg value="ROLE_ADMIN" />
                </bean>
            </list>
        </constructor-arg>
    </bean>

    <bean id="permissionGrantingStrategy" class="org.springframework.security.acls.domain.DefaultPermissionGrantingStrategy">
        <constructor-arg>
            <bean class="org.springframework.security.acls.domain.ConsoleAuditLogger" />
        </constructor-arg>
    </bean>

    <bean id="roleHierarchy" class="org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl">
        <property name="hierarchy">
            <value>
                ROLE_USER > ROLE_ANONYMOUS
                ROLE_SUPER_USER > ROLE_USER
                ROLE_ADMIN > ROLE_SUPER_USER
            </value>
        </property>
    </bean>
</beans>