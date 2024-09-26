import java.util.Map;
import java.util.HashMap;

public class ServiceLocator {
    private final Map<String, Object> beans;

    public ServiceLocator(Map<String, Object> beans) {
        this.beans = beans;
    }

    public <T> T getBean(Class<T> clazz) {
        return (T) beans.get(clazz.getName());
    }

    public static void main(String[] args) {
        Map<String, Object> beans = new HashMap<>();
        beans.put(MyService.class.getName(), new MyService());
        
        ServiceLocator serviceLocator = new ServiceLocator(beans);
        MyService myService = serviceLocator.getBean(MyService.class);
        
        if (myService != null) {
            myService.doSomething();
        } else {
            System.out.println("Service not found");
        }
    }
}

class MyService {
    public void doSomething() {
        System.out.println("Service is doing something!");
    }
}