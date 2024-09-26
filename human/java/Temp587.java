xml
<bean id="channelProcessingFilter" class="org.springframework.security.web.access.channel.ChannelProcessingFilter">
  <property name="channelDecisionManager" ref="channelDecisionManager"/>
  <property name="securityMetadataSource">
        <security:filter-security-metadata-source path-type="ant">
            <security:intercept-url pattern="/services/rest/nohisb/Msgs**" access="REQUIRES_SECURE_CHANNEL" />
            <security:intercept-url pattern="/**/*.html**" access="REQUIRES_SECURE_CHANNEL" />

            <!-- more pattern definition -->

        </security:filter-security-metadata-source>
  </property>
</bean>

<bean id="channelDecisionManager" class="org.springframework.security.web.access.channel.ChannelDecisionManagerImpl">
  <property name="channelProcessors">
    <list>
        <ref bean="secureChannelProcessor"/>
        <ref bean="insecureChannelProcessor"/>
    </list>
  </property>
</bean>

<bean id="secureChannelProcessor" class="org.springframework.security.web.access.channel.SecureChannelProcessor">
    <property name="entryPoint" ref="secureEntryPoint"/>
</bean>

<bean id="insecureChannelProcessor" class="org.springframework.security.web.access.channel.InsecureChannelProcessor">
    <property name="entryPoint" ref="insecureEntryPoint"/>
</bean>

<bean id="secureEntryPoint" class="org.springframework.security.web.access.channel.RetryWithHttpsEntryPoint">
    <property name="portMapper" ref="portMapper"/>
</bean>

<bean id="insecureEntryPoint" class="org.springframework.security.web.access.channel.RetryWithHttpEntryPoint">
    <property name="portMapper" ref="portMapper"/>
</bean>

<bean id="portMapper" class="org.springframework.security.web.PortMapperImpl">
    <property name="portMappings">
        <map>
            <entry key="80" value="443"/>
            <entry key="8081" value="8443"/>
            <entry key="8443" value="8081"/>
            <!-- so on... -->
        </map>
    </property>
</bean>