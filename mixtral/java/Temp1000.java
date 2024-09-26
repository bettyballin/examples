import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class Temp1000 {
    public static void main(String[] args) {
        Temp1000 temp = new Temp1000();
        CommonsMultipartResolver resolver = temp.multipartResolver();
        System.out.println("Multipart Resolver Initialized with max upload size: " + resolver.getMaxUploadSize());
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        final CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();

        // Set the maximum upload size
        commonsMultipartResolver.setMaxUploadSize(-1);

        return commonsMultipartResolver;
    }
}