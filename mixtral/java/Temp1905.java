import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class Temp1905 {
    public static void main(String[] args) {
        Temp1905 temp = new Temp1905();
        CommonsMultipartResolver resolver = temp.commonsMultipartResolver();
        System.out.println("Max upload size: " + resolver.getMaxUploadSize());
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver() {
        final int maxUploadSizeInMb = 5 * 1024 * 1024; // Set your own limit

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();

        multipartResolver.setMaxUploadSize(maxUploadSizeInMb);

        return multipartResolver;
    }
}