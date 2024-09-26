import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

interface ISampleService {
    void execute();
}

@Component("sampleServiceImpl")
class SampleServiceImpl implements ISampleService {
    @Override
    public void execute() {
        System.out.println("Executing SampleServiceImpl...");
    }
}

@Configuration
@ComponentScan(basePackages = "")
class AppConfig {}

@Component
public class Temp645 {
    @Autowired
    @Qualifier("sampleServiceImpl")
    private ISampleService svc;

    public void run() {
        svc.execute();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Temp645 temp645 = context.getBean(Temp645.class);
        temp645.run();
        context.close();
    }
}

Note: I changed `basePackages` to an empty string to scan for components in the default package. If your classes are in a different package, you should replace the empty string with your actual package name.