// MyAuthenticator.php

namespace App\Security;

use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\User\UserProviderInterface;
use Symfony\Component\Security\Core\Authentication\Token\PreAuthenticatedToken;
use Symfony\Component\Security\Core\Exception\AuthenticationException;

class MyAuthenticator implements AuthenticatorInterface
{
    private $userProvider;

    public function __construct(UserProviderInterface $userProvider)
    {
        $this->userProvider = $userProvider;
    }

    public function supports(TokenInterface $token)
    {
        return $token instanceof PreAuthenticatedToken;
    }

    public function authenticate(TokenInterface $token)
    {
        if (!$this->supports($token)) {
            throw new AuthenticationException('Unsupported token');
        }

        $credentials = $token->getCredentials();

        $user = $this->userProvider->loadUserByUsername($credentials);

        if (!$user) {
            throw new AuthenticationException('User not found');
        }

        $authenticatedToken = new PreAuthenticatedToken($user, $credentials, $user->getRoles());
        $authenticatedToken->setAuthenticated(true);

        return $authenticatedToken;
    }

    public function createToken(Request $request, $providerKey)
    {
        $credentials = $request->headers->get('Authorization');

        if (empty($credentials)) {
            throw new AuthenticationException('No credentials provided');
        }

        $token = new PreAuthenticatedToken($credentials, $providerKey);

        return $token;
    }
}