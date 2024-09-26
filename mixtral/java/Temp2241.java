import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Temp2241 {

    private final ComboVahadAmoozeshiRepository combovahadAmoozeshiReposiTory;

    public Temp2241(ComboVahadAmoozeshiRepository combovahadAmoozeshiReposiTory) {
        this.combovahadAmoozeshiReposiTory = combovahadAmoozeshiReposiTory;
    }

    @GetMapping("/getFindByPersonId/{perId}")
    @PreAuthorize("hasRole('USER') and #user.id == principal.id")
    public List<?> getFindBySkhsIdCombo(@PathVariable Long perId, @AuthenticationPrincipal User user) {
        return combovahadAmoozeshiReposiTory.getFindBySksIdCombo(perId);
    }
}

interface ComboVahadAmoozeshiRepository {
    List<?> getFindBySksIdCombo(Long perId);
}

class User {
    public Long id;
}