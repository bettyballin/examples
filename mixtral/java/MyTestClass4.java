import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {
    com.example.configs.AppConfig1.class,
    com.example.configs.AppConfig2.class
})
public class MyTestClass {
    public static void main(String[] args) {
        System.out.println("MyTestClass is configured.");
    }
}