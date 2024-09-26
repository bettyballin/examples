import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Temp1092 {

    private final PhonebookRepository phonebookRepository;

    public Temp1092(PhonebookRepository phonebookRepository) {
        this.phonebookRepository = phonebookRepository;
    }

    @GetMapping("/phonebook")
    public String getPhonebook(Model model, @ModelAttribute User user, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("data", phonebookRepository.findAllByUserEmail(user.getEmail(), PageRequest.of(page, 10)));
        return "phonebook";
    }
}

interface PhonebookRepository {
    Object findAllByUserEmail(String email, PageRequest pageRequest);
}

class User {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}