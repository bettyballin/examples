use Symfony\Component\Security\Core\Authentication\Token\UsernamePasswordToken;
use Symfony\Component\Security\Core\Event\InteractiveLoginEvent;
use Symfony\Component\Security\Core\SecurityEvents;

// Create a user token
$token = new UsernamePasswordToken($user, null, 'main', $user->getRoles());

// Set the authentication token
$this->container->get('security.token_storage')->setToken($token);

// Fire login event
$event = new InteractiveLoginEvent($request, $token);
$this->container->get('event_dispatcher')->dispatch(SecurityEvents::INTERACTIVE_LOGIN, $event);