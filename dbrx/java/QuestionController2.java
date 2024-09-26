import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SpringBootApplication
public class QuestionApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuestionApplication.class, args);
    }
}

@RestController
@RequestMapping("/questions")
class QuestionController {

    @GetMapping("/{questionId}")
    @IsOwnerOrAdmin
    public ResponseEntity<Question> getQuestion(@PathVariable Long questionId) {
        // Mock response for demonstration purposes
        Question question = new Question(questionId, "Sample question?");
        return ResponseEntity.ok(question);
    }
}

// Mock annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface IsOwnerOrAdmin {
}

// Mock Question class
class Question {
    private Long id;
    private String content;

    public Question(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}