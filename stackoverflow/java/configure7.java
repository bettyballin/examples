public void configure7(HttpSecurity http) throws Exception {
    http
    .requestMatchers()
        .antMatchers("/api/**")
        .and()
    .authorizeRequests()
        .antMatchers("/api/books/*").permitAll();
}