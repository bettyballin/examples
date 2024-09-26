import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

// Assuming the necessary imports for AccountDTO, Account, service, eventPublisher, RegistrationCompleteEvent, forceLogin, UserExistsException, log, and Color are present.

@PostMapping("register")
public ModelAndView register(@ModelAttribute("account") @Valid AccountDTO dto, RedirectAttributes attr, HttpServletRequest request) {
    log.info("Registering user");
    log.info("email: " + dto.getEmail());
    try {
        log.info("Checking if user exists");
        Account account = service.register(dto);
        String appUrl = UriComponentsBuilder.fromRequestUri(request)
                .replacePath(request.getContextPath())
                .build()
                .toUriString();
        eventPublisher.publishEvent(new RegistrationCompleteEvent(account, request.getLocale(), appUrl));
        forceLogin(dto.getEmail(), dto.getPassword());
        log.info("redirecting to verification");
        ModelAndView mav = new ModelAndView("redirect:/verification");
        mav.addObject("account", new AccountDTO(dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getCountry(), dto.getPassword(), dto.getConfirmPassword()));
        mav.addObject("cssPath", "../../../../css/index.css");
        return mav;
    } catch (UserExistsException e) {
        log.warn("User exists, redirecting back to signup page DTO: " + dto.getEmail());
        ModelAndView model = new ModelAndView("redirect:/signup");
        attr.addFlashAttribute("account", dto);
        attr.addFlashAttribute("error", "This email already exists!");
        attr.addFlashAttribute("color", Color.ERROR.getColor());
        return model;
    }
}