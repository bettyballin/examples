import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class MyCondition {
    // Define your condition logic here
}

// Configuration class for Config A
@Configuration
@Conditional(MyCondition.class)
public class SecurityConfigA {
    // ...
}

// Configuration class for Config B
@Configuration
@ConditionalOnMissingBean(SecurityConfigA.class)
public class SecurityConfigB {
    // ...
}