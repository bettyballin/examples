import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp1723 {

    // Assuming there's a QuestionService bean
    private final QuestionService questionService;

    public Temp1723(QuestionService questionService) {
        this.questionService = questionService;
    }

    public static void main(String[] args) {
        // Your code to start the application
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') || @questionService.isOwnerOfQuestion(#id, principal.username)")
    @RequestMapping(value = "/deleteQuestion/{id}", method = RequestMethod.DELETE)
    public String deleteQuestion(@PathVariable Long id){
        // Your code to handle the delete operation
        return "Question deleted";
    }
}

interface QuestionService {
    boolean isOwnerOfQuestion(Long id, String username);
}