import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
public class BConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);
        A a = context.getBean(A.class);
        B b = context.getBean(B.class);
        System.out.println(a);
        System.out.println(b);
        context.close();
    }

    @Bean
    public A a(B b) {
        return new A(b);
    }

    @Bean
    public B b() {
        return new B();
    }
}

class A {
    private B b;

    public A(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "A{" + "b=" + b + '}';
    }
}

class B {
    @Override
    public String toString() {
        return "B{}";
    }
}