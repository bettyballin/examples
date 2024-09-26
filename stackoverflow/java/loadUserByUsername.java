public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
    return myUserService.getMyUser(username);
}