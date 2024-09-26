public void configure4(WebSecurity web) {
    web.ignoring().antMatchers(REQUEST_MAPPING_AUTHENTICATEUSER, "/heartBeat", "/subscribe/**");
}