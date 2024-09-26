import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class MyAppSecurityWebApplicationInitializer
  extends AbstractSecurityWebApplicationInitializer {

  public static void main(String[] args) {
    System.out.println("Security Web Application Initializer is set up.");
  }
}