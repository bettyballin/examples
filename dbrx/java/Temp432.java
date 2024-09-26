import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class Temp432 {
    public static void main(String[] args) {
        SpringApplication.run(Temp432.class, args);
    }
}

@RestController
@RequestMapping("/api")
class PersonController {
    @GetMapping(produces = "application/json")
    public ResponseEntity<Person> printHello() {
        Person person = new Person("abcd");
        return ResponseEntity.ok(person);
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

Should be in the same package as the main application class (Temp432.java) or in a sub package of the main package, for component scanning to work correctly. Also, added NoArgConstructor and toString method to the Person class.


package com.example.temp432;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class Temp432 {
    public static void main(String[] args) {
        SpringApplication.run(Temp432.class, args);
    }
}

@RestController
@RequestMapping("/api")
class PersonController {
    @GetMapping(produces = "application/json")
    public ResponseEntity<Person> printHello() {
        Person person = new Person("abcd");
        return ResponseEntity.ok(person);
    }
}

class Person {
    private String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}