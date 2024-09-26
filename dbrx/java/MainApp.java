import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }

    @SpringBootApplication
    @Import(BConfig.class)
    public static class AppConfig {

        @Bean
        public CommandLineRunner commandLineRunner(B b) {
            return args -> System.out.println(b.a.print());
        }
    }
}

@Configuration
class BConfig {

    @Bean
    public A a() {
        return new A();
    }

    @Bean
    public B b(A a) {
        return new B(a);
    }
}

class A {
    public String print() {
        return "Hello from A!";
    }
}

class B {
    public final A a;

    public B(A a) {
        this.a = a;
    }
}

No changes needed. This code already compiles without errors. 

However, the `@SpringBootApplication` annotation should be at the main application class `MainApp` not at the `AppConfig` class.

Here's the corrected code:


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(BConfig.class)
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(B b) {
        return args -> System.out.println(b.a.print());
    }
}

@Configuration
class BConfig {

    @Bean
    public A a() {
        return new A();
    }

    @Bean
    public B b(A a) {
        return new B(a);
    }
}

class A {
    public String print() {
        return "Hello from A!";
    }
}

class B {
    public final A a;

    public B(A a) {
        this.a = a;
    }
}