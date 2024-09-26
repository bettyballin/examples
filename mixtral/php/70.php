Here is the executable PHP code:


// src/Acme/SecurityBundle/EventListener/LoginLogoutLogger.php

namespace Acme\SecurityBundle\EventListener;

use Psr\Log\LoggerInterface;
use Symfony\Component\EventDispatcher\EventSubscriberInterface;
use Symfony\Component\HttpKernel\Event\GetResponseForExceptionEvent;
use Symfony\Component\HttpFoundation\RequestStack;
use Symfony\Component\Security\Core\AuthenticationEvents;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Security\Http\Event\InteractiveLoginEvent;
use Symfony\Component\Security\Http\Event\LogoutEvent;

class LoginLogoutLogger implements EventSubscriberInterface
{
    private $logger;

    public function __construct(LoggerInterface $logger)
    {
        $this->logger = $logger;
    }

    /**
     * {@inheritdoc}
     */
    public static function getSubscribedEvents()
    {
        return array(
            AuthenticationEvents::AUTHENTICATION_SUCCESS => 'onAuthenticationSuccess',
            AuthenticationEvents::INTERACTIVE_LOGIN => 'onInteractiveLogin',
            LogoutEvent::class => 'onLogout'
        );
    }

    public function onAuthenticationSuccess()
    {
        $this->logger->info('User logged in');
    }

    public function onInteractiveLogin(InteractiveLoginEvent $event)
    {
        $user = $event->getAuthenticationToken()->getUser();

        if ($user instanceof UserInterface) {
            $this->logger->info('Username: ' . $user->getUsername());
        }
    }

    public function onLogout(LogoutEvent $event)
    {
        $this->logger->info('User logged out');
    }
}