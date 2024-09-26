import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class A {
    // A class implementation
}

class B {
    private A a;

    public void setA(A a) {
        this.a = a;
    }

    // B class implementation
}

@Configuration
public class AConfig {  
    @Bean
    public A a() {
        return new A();
    }

    @Bean
    public B b() {
        B b = new B();
        b.setA(a());
        return b;
    }
}