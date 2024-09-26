use Symfony\Component\Security\Core\Authentication\Token\UsernamePasswordToken;
use Symfony\Component\Security\Http\Event\InteractiveLoginEvent;
use Symfony\Component\Security\Http\SecurityEvents;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Security\Guard\GuardAuthenticatorHandler;
use Symfony\Component\Security\Guard\Authenticator\FormLoginAuthenticator;
use Symfony\Component\DependencyInjection\ContainerInterface;

class LoginController
{
    private $container;

    public function __construct(ContainerInterface $container)
    {
        $this->container = $container;
    }

    public function login(Request $request, GuardAuthenticatorHandler $guardHandler, FormLoginAuthenticator $formAuthenticator)
    {
        // Authenticate the user manually using a UsernamePasswordToken
        $user = // Get your user object from database or external system;
        $token = new UsernamePasswordToken($user, null, 'main', $user->getRoles());
        $this->container->get('security.token_storage')->setToken($token);

        // Dispatch the login event to set up other services like session and remember_me cookie
        $event = new InteractiveLoginEvent($request, $token);
        $this->container->get('event_dispatcher')->dispatch(SecurityEvents::INTERACTIVE_LOGIN, $event);

        return $guardHandler->authenticateUserAndHandleSuccess(
            $user,
            $request,
            $formAuthenticator,
            'main'
        );
    }
}