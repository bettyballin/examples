import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Temp2550 {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("frien", new Customer());
        return "form";
    }

    @PostMapping("/form")
    public String getPost(@ModelAttribute("frien") Customer frienCustomer) {
        // Process the frienCustomer object
        return "result";
    }

    public static void main(String[] args) {
        SpringApplication.run(Temp2550.class, args);
    }

    public static class Customer {
        private Long id;
        private String name;

        // Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}


html
<!-- form.html -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Form</title>
</head>
<body>
    <form action="#" th:action="@{/form}" th:object="${frien}" method="post">
        <input type="hidden" th:field="*{id}" />
        <input type="text" th:field="*{name}" placeholder="Name" />
        <button type="submit">Submit</button>
    </form>
</body>
</html>


html
<!-- result.html -->
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Result</title>
</head>
<body>
    <p>Form submitted successfully!</p>
</body>
</html>