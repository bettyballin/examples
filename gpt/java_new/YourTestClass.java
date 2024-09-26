import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = YourConfigClass.class)
@ContextConfiguration(locations = {
    "classpath:/config/spring-config1.xml",
    "classpath:/config/spring-config2.xml"
})
public class YourTestClass {
    // your test case methods
}