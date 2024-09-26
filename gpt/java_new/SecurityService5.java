import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityService5 {

    private final QuestionService questionService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityService5(QuestionService questionService, UserDetailsService userDetailsService) {
        this.questionService = questionService;
        this.userDetailsService = userDetailsService;
    }

    public boolean isOwner(Long questionId) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        UserDetails currentUser = userDetailsService.loadUserByUsername(currentUsername);
        Question question = questionService.getQuestionById(questionId);
        return question.getOwnerUsername().equals(currentUser.getUsername());
    }
}