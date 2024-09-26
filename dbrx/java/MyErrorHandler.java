import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.web.servlet.error.ErrorController;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Controller
    @EnableWebMvc
    public static class MyErrorHandler implements ErrorController {

        @Override
        public String getErrorPath() {
            return "/error";
        }

        @RequestMapping("/error")
        public ResponseEntity<String> handleError(HttpServletRequest request) {
            Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
            Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");

            if (exception instanceof BeanCreationException && "myBeanName".equals(((BeanCreationException) exception).getBeanName())) {
                return new ResponseEntity<>("HURRAY: myBeanName", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            // Handle other exceptions or status codes here
            return new ResponseEntity<>("Error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}