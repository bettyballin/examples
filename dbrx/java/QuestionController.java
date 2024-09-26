import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService; // Assuming there is a service to fetch questions

    @GetMapping("/{questionId}")
    @PreAuthorize("hasRole('ADMIN') or #person.id == authentication.principal.id")
    public ResponseEntity<Question> getQuestion(@PathVariable Long questionId, @AuthenticationPrincipal Person person) {
        Question question = questionService.getQuestionById(questionId);
        if (question == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(question);
    }
}

class QuestionService {
    public Question getQuestionById(Long questionId) {
        // Mock implementation to fetch question by ID
        return new Question(questionId, new Person(1L));
    }
}

class Question {
    private Long id;
    private Person person;

    public Question(Long id, Person person) {
        this.id = id;
        this.person = person;
    }

    // getters and setters
}

class Person {
    private Long id;

    public Person(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    // setters
}