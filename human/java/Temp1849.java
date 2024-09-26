import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.context.annotation.Bean;

public class Temp1849 {
    public static void main(String[] args) {
        Temp1849 temp = new Temp1849();
        ServletListenerRegistrationBean<HttpSessionEventPublisher> bean = temp.httpSessionEventPublisher();
        System.out.println("Bean created: " + bean);
    }

    @Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }
}