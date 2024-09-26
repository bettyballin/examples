public void configure3(WebSecurity web) {
  web.ignoring()
     .antMatchers("/metrics/**", "/health/**", "/logfile/**", "/systemcheck/**");
}