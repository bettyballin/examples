public void configure5(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers(HttpMethod.PUT, "/api/{\\d+}/action/**")
        .access("hasAnyRole('View_account','Search_account')");
}