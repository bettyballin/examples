import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        MySuccessHandler handler = (MySuccessHandler) context.getBean("mySuccessHandler");
        handler.handleSuccess();
    }
}

package my.domain;

public class MySuccessHandler {
    public void handleSuccess() {
        System.out.println("Handling success!");
    }
}


xml
<!-- beans.xml -->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="mySuccessHandler" class="my.domain.MySuccessHandler" />
</beans>