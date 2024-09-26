xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="methodSecurityAccessDecisionManager"
          class="some.package.MethodSecurityAccessDecisionManager">

        <constructor-arg>
            <map>
                <entry key="GetByOwner">
                    <bean class="some.package.GetByOwnerStrategy"/>
                </entry>

                <entry key="SomeOther">
                    <bean class="some.package.SomeOtherStrategy"/>
                </entry>
            </map>
        </constructor-arg>

    </bean>

</beans>