public void configure12(WebSecurity web) {
    web
        .ignoring()
        .antMatchers("/api/v0/auth/login");
}