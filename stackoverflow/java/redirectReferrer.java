// Assuming this is within a method in a Spring MVC controller

import javax.servlet.http.HttpServletRequest;

// ...

public String redirectReferrer(HttpServletRequest request) {
    String referrer = request.getHeader("referer");
    return "redirect:" + (referrer != null ? referrer : "/");
}