use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authenticator\AbstractAuthenticator;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\DependencyInjection\ContainerAwareTrait;
use Symfony\Component\Security\Core\Authentication\Token\Token;

class AjaxAuthenticator extends AbstractAuthenticator
{
    use ContainerAwareTrait;

    public function authenticateToken(TokenInterface $token): ?TokenInterface
    {
        // Check if the request is an AJAX request
        if (!$this->isAjaxRequest()) {
            return null;
        }

        // Get the user from the token
        $user = $token->getUser();

        // Check if the user is authenticated
        if (!$user instanceof UserInterface) {
            return null;
        }

        // Return a new token with the authenticated user
        return new Token($user);
    }

    private function isAjaxRequest(): bool
    {
        // Check if the request has the AJAX flag set
        return $this->container->get('request')->headers->has('X-Requested-With') && 'XMLHttpRequest' === $this->container->get('request')->headers->get('X-Requested-With');
    }
}