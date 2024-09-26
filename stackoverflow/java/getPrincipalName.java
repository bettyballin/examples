// The provided code snippet is incomplete and cannot be compiled as-is. However, assuming the missing parts,
// here is a refactored version that could be part of a compilable method:

public String getPrincipalName(Authentication authentication) {
    if (authentication != null && authentication.getPrincipal() instanceof KeycloakPrincipal) {
        KeycloakPrincipal<?> principal = (KeycloakPrincipal<?>) authentication.getPrincipal();
        return principal.getName();
    }
    return null; // or throw an exception, depending on the context
}