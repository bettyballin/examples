namespace MyBundle\Security;

use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\RouterInterface;
use Symfony\Component\EventDispatcher\EventSubscriberInterface;
use Symfony\Component\HttpKernel\Event\GetResponseEvent;
use Symfony\Component\HttpFoundation\Session\Session;

class LogoutListener implements EventSubscriberInterface
{
    private $router;
    private $session;

    public function __construct(RouterInterface $router, Session $session)
    {
        $this->router = $router;
        $this->session = $session;
    }

    /**
     * @inheritDoc
     */
    public static function getSubscribedEvents()
    {
        return [
            'kernel.request' => ['onKernelRequest', 10]
        ];
    }

    public function onKernelRequest(GetResponseEvent $event)
    {
        if (!$this->isAdminArea($event)) {
            // Not an admin area do nothing
            return;
        }

        $request = $event->getRequest();

        if ($logoutRouteName = $this->shouldLogOutUser($request) && 'POST' === $request->getMethod()) {

            $response = new Response('', 302);
            $event->setResponse($response);
        }
    }

    private function isAdminArea(GetResponseEvent $event)
    {
        // implement logic to check if the request is for an admin area
    }

    private function shouldLogOutUser($request)
    {
        // implement logic to check if the user should be logged out
    }
}