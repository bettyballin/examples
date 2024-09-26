import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Temp1245 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Account currentAccount = (Account) context.getBean("CurrentAccount");
        System.out.println(currentAccount);
    }
}

class Authentication {
    public Account getAccount() {
        return new Account();
    }
}

class Account {
    @Override
    public String toString() {
        return "This is the current account";
    }
}

@Configuration
class AppConfig {

    @Bean(name = "CurrentAccount")
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Account currentAccount() {
        return new Authentication().getAccount();
    }
}


beans.xml:
xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/aop
           http://www.springframework.org/schema/aop/spring-aop.xsd">

    <bean id="CurrentAccount" factory-bean="authentication" factory-method="getAccount" scope="request">
        <aop:scoped-proxy/>
    </bean>

    <bean id="authentication" class="Authentication" />

</beans>