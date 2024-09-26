use Symfony\Component\HttpKernel\Event\FilterResponseEvent;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

class DeviceCookieListener
{
    private $container;

    public function __construct($container)
    {
        $this->container = $container;
    }

    public function onKernelResponse(FilterResponseEvent $event)
    {
        // Get security context
        $securityContext = $this->container->get('security.context');

        // Check if user is authenticated
        if ($securityContext->isGranted('IS_AUTHENTICATED_FULLY')) {
            $request = $event->getRequest();
            // If no device cookie exists create one
            if (!$request->cookies->has(DeviceManager::COOKIE_PREFIX . 'id') && $this->getCurrentFirewall($request)) {
                $deviceManager = $this->container->get('salus_user.device_manager');
                $cookie = $deviceManager->createDeviceCookie();

                // Add cookie to response
                $response = $event->getResponse();
                $response->headers->setCookie($cookie);
            }
        }
    }

    private function getCurrentFirewall(Request $request)
    {
        foreach ($this->container->getParameter('security.firewalls') as $name => $config) {
            if (preg_match('/^' . strtr($config['pattern'], array('\\*' => '.*', '\\?' => '.?')) . '$/i', rawurldecode(strtok((string)$request->getPathInfo(), '?'))))
                return $name;
        }

        // No firewall found
        return false;
    }
}