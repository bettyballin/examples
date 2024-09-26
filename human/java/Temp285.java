xml
<bean id="pbrADH" class="com.foo.PageByResourceAccessDeniedHandler">
  <property name="defaultErrorPage" value="/errorpagedefault.jsp" />
  <property name="errorPagesByPaths">
    <map>
      <entry key="/aaa/**" value="/errorpageaaa.jsp" />
      <entry key="/bbb/**" value="/errorpagebbb.jsp" />
    </map>
  </property>
</bean>