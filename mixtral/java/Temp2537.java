import org.springframework.context.annotation.Bean;

public class Temp2537 {
    public static void main(String[] args) {
        Temp2537 temp = new Temp2537();
        System.out.println(temp.loginPageUrl());
    }

    @Bean
    public String loginPageUrl() {
        return "/login";
    }
}