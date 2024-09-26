import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

public class Temp1266 {
    public static void main(String[] args) {
        Temp1266 app = new Temp1266();
        MultipartConfigElement config = app.multipartConfigElement();
        System.out.println("Max file size: " + config.getMaxFileSize());
        System.out.println("Max request size: " + config.getMaxRequestSize());
    }

    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("128MB");
        factory.setMaxRequestSize("128MB");

        return factory.createMultipartConfig();
    }
}

Note that I simply removed the `@Bean` annotation, as it's not needed in this context. `@Bean` is a Spring annotation used to create beans in a Spring application context, but in this simple Java class, it's not applicable.