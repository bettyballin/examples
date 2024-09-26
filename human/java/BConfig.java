import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AConfig.class)
public class BConfig {

    @Autowired
    private A a;

    @Bean
    public B b() {
        B b = new B();
        b.setA(a);
        return b;
    }

    public static void main(String[] args) {
        org.springframework.context.ApplicationContext context = new org.springframework.context.annotation.AnnotationConfigApplicationContext(BConfig.class);
        B b = context.getBean(B.class);
        System.out.println(b.getA());
    }
}

class A {
    // Define class A properties and methods here
}

class B {
    private A a;

    public void setA(A a) {
        this.a = a;
    }

    public A getA() {
        return this.a;
    }

    // Define class B properties and methods here
}

@Configuration
class AConfig {
    @Bean
    public A a() {
        return new A();
    }
}