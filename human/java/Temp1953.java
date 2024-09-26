import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Temp1953 {
    public static void main(String[] args) {
        Temp1953 temp = new Temp1953();
        SpringDataSourceBeanPostProcessor processor = temp.monitoringDataSourceBeanPostProcessor();
        System.out.println(processor);
    }

    @Bean
    public SpringDataSourceBeanPostProcessor monitoringDataSourceBeanPostProcessor() {
        SpringDataSourceBeanPostProcessor processor = new SpringDataSourceBeanPostProcessor();
        processor.setExcludedDatasources(null);
        return processor;
    }
}

class SpringDataSourceBeanPostProcessor {

    private Object excludedDatasources;

    public void setExcludedDatasources(Object excludedDatasources) {
        this.excludedDatasources = excludedDatasources;
    }

    @Override
    public String toString() {
        return "SpringDataSourceBeanPostProcessor{" +
                "excludedDatasources=" + excludedDatasources +
                '}';
    }
}