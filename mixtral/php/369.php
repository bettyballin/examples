use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\Security\Core\Authentication\Token\UsernamePasswordToken;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\User\UserInterface;

class AdminLoginAuthenticator extends AbstractFormLoginAuthenticator
{
    public function onAuthenticationSuccess(Request $request, TokenInterface $token, string $firewallName): ?Response
    {
        if ($this->container->get('security.authorization_checker')->isGranted('ROLE_ADMIN')) {
            $user = $token->getUser();
            $mainToken = new UsernamePasswordToken($user, null, 'main', ['ROLE_USER']);

            // Store the main token in TokenStorage
            $tokenStorage = $this->container->get('security.token_storage');
            $tokenStorage->setToken($mainToken);
        }

        return new RedirectResponse('/admin/dashboard');
    }
}