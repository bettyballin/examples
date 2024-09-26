import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SpringBootApplication
public class Temp1898 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1898.class, args);
    }

    @Bean
    public Servlet exampleServlet() {
        return new ExampleServlet();
    }

    @Bean
    public Filter exampleFilter() {
        return new ExampleFilter();
    }

    @Bean
    public ServletContextListener exampleListener() {
        return new ExampleListener();
    }

    @WebServlet(urlPatterns = "/exampleServlet")
    public static class ExampleServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            resp.getWriter().write("Hello from ExampleServlet");
        }
    }

    @WebFilter(urlPatterns = "/*")
    public static class ExampleFilter implements Filter {
        // Implement filter methods
    }

    @WebListener
    public static class ExampleListener implements ServletContextListener {
        // Implement listener methods
    }
}