import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String login(@RequestParam(name = "targetUrl", required = false, defaultValue = "") String targetUrl, Model model) {
        if (StringUtils.hasText(targetUrl)) {
            model.addAttribute("targetUrl", targetUrl);
        }
        return "login";
    }

}