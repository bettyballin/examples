import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class Temp3241 {
    public static void main(String[] args) {
        Temp3241 temp = new Temp3241();
        FilterRegistrationBean<MyFilter> frb = temp.myFilterRegistrationBean(new MyFilter());
        System.out.println("Filter enabled: " + frb.isEnabled());
    }

    @Bean
    public FilterRegistrationBean<MyFilter> myFilterRegistrationBean(MyFilter myFilter) {
        FilterRegistrationBean<MyFilter> frb = new FilterRegistrationBean<>(myFilter);
        frb.setEnabled(false);
        return frb;
    }
}

class MyFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code goes here
    }

    @Override
    public void destroy() {
        // Cleanup code goes here
    }
}