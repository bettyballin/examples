use Symfony\Component\Security\Core\Authentication\AuthenticationManagerInterface;
use Symfony\Component\Security\Core\Exception\BadCredentialsException;
use Symfony\Component\Security\Core\Authentication\Token\UsernamePasswordToken;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\HttpFoundation\Response;

public function alternateLoginAction($username, $password)
{
    // Get Authentication Manager from the container (or inject as a service in your controller).
    /** @var AuthenticationManagerInterface $authenticationManager */
    $authenticationManager = $this->get('security.authentication.manager');

    try {
        // Create token with provided username and password.
        $token = new UsernamePasswordToken($username, $password);

        // Authenticate the user using authentication manager (it will throw an exception if it fails).
        /** @var TokenInterface $authenticatedToken */
        $authenticatedToken = $authenticationManager->authenticate($token);
    } catch (BadCredentialsException $e) {
        return new Response('Invalid username or password.', 401);
    }

    // If the authentication was successful you can now use authenticated token to get user and roles.
}