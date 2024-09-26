import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/springtest")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{empId}")
    @PreAuthorize("@securityService.hasAccess(#empId, authentication)")
    public String getEmployeeInfo(@PathVariable Long empId, Model model, Principal principal) {
        Employee employee = employeeService.getEmployeeById(empId);
        model.addAttribute("employee", employee);
        return "empInfo";
    }
}