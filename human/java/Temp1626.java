import org.springframework.cache.annotation.Cacheable;

public class Temp1626 {
    public static void main(String[] args) {
        Temp1626 instance = new Temp1626();
        Foo result = instance.doIt("exampleKey");
        System.out.println(result);
    }

    @Cacheable(cacheNames = "myCache", condition = "T(com.example.SecurityChecker).isSecured()")
    public Foo doIt(String key) {
        return new Foo(key);
    }

    static class Foo {
        private String key;

        public Foo(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "Foo{" +
                    "key='" + key + '\'' +
                    '}';
        }
    }
}

class SecurityChecker {
    public static boolean isSecured() {
        // Implement security check logic here
        return true;
    }
}