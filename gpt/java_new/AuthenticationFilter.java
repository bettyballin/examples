public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        // Check if the user is logged in
        Boolean isLoggedIn = (Boolean) req.getSession().getAttribute("estaLoggeado");
        
        // Identify the requested URI
        String reqURI = req.getRequestURI();
        
        // Check if it's a resource request or a public page
        boolean isResourceRequest = reqURI.contains("javax.faces.resource");
        boolean isPublicPage = reqURI.contains("/index.xhtml") || reqURI.contains("/public/");
        
        // If it's a resource request or public page, or if the user is logged in, proceed with the chain
        if (isResourceRequest || isPublicPage || Boolean.TRUE.equals(isLoggedIn)) {
            chain.doFilter(request, response);
        } else {
            // Redirect to login page or handle not being logged in
            res.sendRedirect(req.getContextPath() + "/login.xhtml"); // Assuming "/login.xhtml" is the login page
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filter initialization logic here
    }

    @Override
    public void destroy() {
        // Filter cleanup logic here
    }
}