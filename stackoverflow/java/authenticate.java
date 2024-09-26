public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    if (username == null) {
        throw new AuthenticationCredentialsNotFoundException("No credentials found in context");
    }
    
    UserDetails user = getUserDetailsService().loadUserByUsername(username);
    if (!getPasswordEncoder().matches((String) authentication.getCredentials(), user.getPassword())) {
        throw new BadCredentialsException("Password incorrect");
    }
    
    if (!user.isEnabled()) {
        throw new DisabledException("User is disabled");
    }
    
    Date now = new Date();
    UserDetailsChecker preAuthenticationChecks = userDetails -> {
        if (!user.isAccountNonLocked()) {
            throw new LockedException("User account is locked");
        }
        if (!user.isAccountNonExpired()) {
            throw new AccountExpiredException("User account has expired");
        }
        if (!user.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("User credentials have expired");
        }
    };
    preAuthenticationChecks.check(user);
    
    return new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), user.getAuthorities());
}