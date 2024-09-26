package chores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"chores", "security"})
public class ChoreApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ChoreApplication.class, args);
    }
}