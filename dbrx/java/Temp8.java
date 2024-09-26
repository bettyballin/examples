public class Temp8 {
    public static void main(String[] args) {
        // Example usage of MyService
        MyService service = new MyServiceImpl();

        service.doSomething();
    }

    public interface MyService {
        void doSomething();
    }

    public static class MyServiceImpl implements MyService {
        @Override
        public void doSomething() {
            System.out.println("Doing something");
        }
    }
}