import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Component
public class CustomStatusFilter extends OncePerRequestFilter {

    @Autowired
    private CustomerService customerService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof IPanelUser) {
                IPanelUser pUser = (IPanelUser) principal;
                Customer customer = customerService.getUserByUsername(pUser.getUsername());
                if (customer != null) {
                    switch (customer.getStatus()) {
                        case SUSPENDED:
                            response.sendRedirect(request.getContextPath() + "/suspended");
                            return;
                        case BLOCKED:
                            response.sendRedirect(request.getContextPath() + "/blocked");
                            return;
                        default:
                            break;
                    }
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}