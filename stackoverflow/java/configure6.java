public void configure6(WebSecurity web) {
    web.ignoring().antMatchers("/my/**");
}