use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\Security\Core\Exception\AuthenticationException;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Security\Core\User\UserProviderInterface;
use Symfony\Component\Security\Csrf\CsrfTokenManagerInterface;
use Symfony\Component\Security\Guard\AbstractFormLoginAuthenticator;

class CustomAuthenticator extends AbstractFormLoginAuthenticator
{
    private $session;

    public function __construct(SessionInterface $session)
    {
        $this->session = $session;
    }

    public function onAuthenticationSuccess(Request $request, TokenInterface $token, $firewallName): ?Response
    {
        if (!$this->session->has('is_logged_in')) { 
            // Log the login event here.
            
            $this->session->set('is_logged_in', true);
        }
        
        return null;
    }

    public function supports(Request $request): bool
    {
        return 'app_login' === $request->attributes->get('_route')
               && $request->isMethod('POST');
    }
}