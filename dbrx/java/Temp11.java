import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

interface MyService {
    void doSomething();
}

@Component
@Primary
class StaticCredentialsServiceImpl implements MyService {
    @Override
    public void doSomething() {
        System.out.println("Static credentials service implementation.");
    }
}

@Component
class UserInputCredentialsServiceImpl implements MyService {
    @Override
    public void doSomething() {
        System.out.println("User input credentials service implementation.");
    }
}

@Component
public class Temp11 {

    @Autowired
    private MyService staticCredentialsService;

    @Autowired
    private MyService userInputCredentialsService;

    private boolean useStaticCreds = true; // or false based on your requirement

    public static void main(String[] args) {
        // Initialize Spring context
        org.springframework.context.ApplicationContext context = 
                new org.springframework.context.annotation.AnnotationConfigApplicationContext(Temp11.class, StaticCredentialsServiceImpl.class, UserInputCredentialsServiceImpl.class);

        Temp11 temp11 = context.getBean(Temp11.class);
        temp11.execute();
    }

    public void execute() {
        if (useStaticCreds) {
            staticCredentialsService.doSomething();
        } else {
            userInputCredentialsService.doSomething();
        }
    }
}