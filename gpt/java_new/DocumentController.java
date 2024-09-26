import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DocumentController {

    private final TextEncryptor encryptor;

    public DocumentController(TextEncryptor encryptor) {
        this.encryptor = encryptor;
    }

    @GetMapping("/document")
    public String getDocument(Model model, @RequestParam String path) {
        String encryptedPath = encryptor.encrypt(path);
        model.addAttribute("encryptedPath", encryptedPath);
        return "document";
    }
}