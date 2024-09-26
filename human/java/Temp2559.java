// Required dependencies: spring-webmvc, javax.servlet-api

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@ComponentScan(basePackages = "your.package.name")
public class RegistrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegistrationApplication.class, args);
    }
}

@Controller
public class RegistrationController {

    @GetMapping("/index")
    public String showForm(Model model) {
        model.addAttribute("text1", "");
        return "index";
    }

    @PostMapping("/index")
    public String submitForm(@RequestParam("textForm") String textForm, Model model) {
        model.addAttribute("text1", textForm);
        model.addAttribute("textFinal", textForm);
        return "index";
    }
}


html
<!-- index.html in src/main/resources/templates -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>

    <form action="/index" method="POST">
        <div class="form-group">
            <textarea class="form-control" name="textForm">${text1}</textarea>
            <input type="submit" value="Submit">
            <textarea name="textFin">${textFinal}</textarea>
        </div>
    </form>

</body>
</html>


**Note:** Make sure to replace `your.package.name` with the actual package name you are using in your project. Additionally, you need to include the required dependencies for Spring Boot and Thymeleaf in your `pom.xml` or `build.gradle` file.