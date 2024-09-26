public class JWTAuthenticationFilter2 extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String requestURI = httpRequest.getRequestURI();

        if ("/users/login".equals(requestURI) || "/token/refresh".equals(requestURI)) {
            chain.doFilter(request, response);
            return;
        }

        // Authentication logic here

        chain.doFilter(request, response);
    }
}