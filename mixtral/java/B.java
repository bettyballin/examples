import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class A {
    // Class A implementation
}

class B {
    private A a;

    @Autowired
    public void setA(final A a) {
        this.a = a;
    }

    // Rest of your code
}

@Configuration
class ACfg {
    @Bean
    public A a() {
        return new A();
    }
}

@Configuration
@Import({ACfg.class})
class BCfg {
    @Bean
    public B b() {
        return new B();
    }
}

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BCfg.class);
        B b = context.getBean(B.class);
        // Use the B instance
        context.close();
    }
}