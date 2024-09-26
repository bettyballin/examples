import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(
  name = "my.condition.enabled", 
  havingValue = "false", 
  matchIfMissing = true)
public class ConfigurationB {
  // ...
}

@Configuration
@ConditionalOnProperty(
  name = "my.condition.enabled", 
  havingValue = "true")
public class ConfigurationA {
  // ...
}