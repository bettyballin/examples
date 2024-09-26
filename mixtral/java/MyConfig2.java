import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;

@Configuration
public class MyConfig {

  @Autowired
  private MonitoringFilter monitoringFilter;

  @PostConstruct
  public void init() {
    monitoringFilter.setAllowedAddressPattern("127\\.0\\..*");
  }
}

class MonitoringFilter {
  private String allowedAddressPattern;

  public void setAllowedAddressPattern(String pattern) {
    this.allowedAddressPattern = pattern;
  }
}