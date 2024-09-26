import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectController {

   @PreAuthorize("hasPermission(#projectId, 'Project', 'read')")
   @RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
   public String getProject(@PathVariable("projectId") Long projectId, Model model) {
       // Your code here
       return "projectView";
   }
}