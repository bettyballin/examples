public void configure1(WebSecurity web) {
    web.ignoring().antMatchers("/api/login", "/api/logout");
}