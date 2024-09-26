xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="accessDecisionManager" class="org.springframework.security.access.vote.ConsensusBased">
        <property name="allowIfAllAbstainDecisions" value="false" />
        <property name="decisionVoters">
            <list>
                <ref bean="roleVoter"  />
                <ref bean="authVoter" />
            </list>
        </property>
    </bean>

    <bean id="roleVoter" class="org.springframework.security.access.vote.RoleVoter" />
    <bean id="authVoter" class="org.springframework.security.access.vote.AuthenticatedVoter" />

</beans>