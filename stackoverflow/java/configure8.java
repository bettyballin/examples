public void configure8(WebSecurity web) {
    web.ignoring()
       .antMatchers("/css/**", "/anyThingRequiredByLoginPageToWork/**");
}