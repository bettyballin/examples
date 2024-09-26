public class CustomAuthenticationSuccessHandler11 implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String userId = getUserIdFromAuthentication(authentication);
        String targetUrl = "/users/" + userId;
        response.sendRedirect(targetUrl);
    }

    private String getUserIdFromAuthentication(Authentication authentication) {
        // Dummy implementation, replace with actual logic to extract user ID
        return authentication.getName(); // Assuming the user ID is the username
    }
}