use Symfony\Component\Security\Core\Authentication\Token\JWTAuthenticationToken;

// Dealer authentication
$token = $this->get('security.authenticator')->authenticateToken(
    new JWTAuthenticationToken($request->headers->get('Authorization'), 'dealer')
);

// Customer authentication
$token = $this->get('security.authenticator')->authenticateToken(
    new JWTAuthenticationToken($request->headers->get('Authorization'), 'customer')
);