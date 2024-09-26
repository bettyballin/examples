use Symfony\Component\EventDispatcher\EventSubscriberInterface;
use Symfony\Component\HttpKernel\Event\GetResponseEvent;

class UserSubscriber implements EventSubscriberInterface
{
    private $app;

    public function __construct($app)
    {
        $this->app = $app;
    }

    public static function getSubscribedEvents()
    {
        return [
            'kernel.request' => 'onRequest',
        ];
    }

    /**
     * @param GetResponseEvent $event
     */
    public function onRequest(GetResponseEvent $event): void
    {
        if (!$event->isMasterRequest()) return;

        $tokenStorage = $this->app['security.token_storage'];

        // Check for a valid token
        if ($tokenStorage && null !== $userToken = $tokenStorage->getToken() )
            $loggedInUser = $userToken->getUser();

        // Add the user to Twig globals
        $this->app['twig']->addGlobal('currentUser', $loggedInUser);
    }
}