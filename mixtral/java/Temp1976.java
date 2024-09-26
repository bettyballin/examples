import org.springframework.context.annotation.Bean;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

public class Temp1976 {
    public static void main(String[] args) {
        Temp1976 instance = new Temp1976();
        LayoutDialect layoutDialect = instance.layoutDialect();
        System.out.println(layoutDialect);
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}