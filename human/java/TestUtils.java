import org.springframework.aop.framework.AopUtils;
import org.springframework.aop.framework.Advised;

class TestUtils {
    public static Object unwrapService(Object service) throws Exception {
        final boolean aopProxy = AopUtils.isAopProxy(service);
        final boolean instanceCheck = service instanceof Advised;
        if (aopProxy && instanceCheck) {
            Object target = ((Advised) service).getTargetSource().getTarget();
            return target;
        }
        return null;
    }

    public static void main(String[] args) {
        // Example usage (requires a Spring context and a proxied service)
        // ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // MyService myService = context.getBean(MyService.class);
        // try {
        //     Object unwrappedService = unwrapService(myService);
        //     System.out.println("Unwrapped Service: " + unwrappedService);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }
}