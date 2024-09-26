use Symfony\Component\Security\Core\Event\InteractiveLoginEvent;

class LoginListener
{
    public function onInteractiveLogin(InteractiveLoginEvent $event)
    {
        if (null !== ($user = $event->getAuthenticationToken()->getUser())) {
            // Log The User Here.
            // Example:
            $logger = new \Monolog\Logger('security');
            $logger->info('User logged in', ['username' => $user->getUsername()]);
        }
    }
}