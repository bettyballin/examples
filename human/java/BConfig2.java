import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
public class BConfig {  

    @Autowired
    private AConfig aConfig;

    @Bean
    public B b() {
        B b = new B();
        b.setA(aConfig.a());
        return b;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class, AConfig.class);
        B bBean = context.getBean(B.class);
        System.out.println(bBean);
        context.close();
    }
}

@Configuration
class AConfig {

    @Bean
    public A a() {
        return new A();
    }
}

class A {
    // A class implementation
}

class B {
    private A a;

    public void setA(A a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                '}';
    }
}