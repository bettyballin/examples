// Assuming the existence of a `TokenStore` interface with the method `findTokensByClientIdAndUserName`
// and a class that implements UserDetails where `getUsername` is a method.
// This snippet should be part of a method within a class.

public void findUserTokens(TokenStore tokenStore, UserDetails userDetails) {
    tokenStore.findTokensByClientIdAndUserName("your Client Id", userDetails.getUsername());
}