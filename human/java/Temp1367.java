import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Temp1367 {

    @RequestMapping("/addbanners")
    public ModelAndView addbanners(@ModelAttribute Banner banner, 
                                   @RequestParam("uploadBanner") MultipartFile file) {
        // Add your business logic here
        ModelAndView modelAndView = new ModelAndView("result");
        // Assume some processing of banner and file here
        modelAndView.addObject("banner", banner);
        modelAndView.addObject("file", file.getOriginalFilename());
        return modelAndView;
    }

    public static void main(String[] args) {
        // Spring application entry point would usually go here
    }
}

class Banner {
    // Assume some fields and getter/setters here
}