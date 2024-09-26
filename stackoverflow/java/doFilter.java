public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
    if (!(request instanceof HttpServletRequest)) {
        chain.doFilter(request, response);
        return;
    }

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    httpRequest.getSession().invalidate();
    // Continue filter chain
    chain.doFilter(request, response);
}