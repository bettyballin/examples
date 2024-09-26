public UserDetailsService userDetailsServiceBean() {
    return super.userDetailsServiceBean();
}

public DigestAuthenticationFilter digestAuthenticationFilter(DigestAuthenticationEntryPoint digestAuthenticationEntryPoint) {
    DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
    digestAuthenticationFilter.setAuthenticationEntryPoint(digestAuthenticationEntryPoint);
    digestAuthenticationFilter.setUserDetailsService(userDetailsServiceBean());
    return digestAuthenticationFilter;
}