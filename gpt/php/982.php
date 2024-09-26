
// src/EventListener/PortListener.php

namespace App\EventListener;

use Symfony\Component\HttpKernel\Event\RequestEvent;
use Symfony\Component\HttpFoundation\Response;

class PortListener
{
    public function onKernelRequest(RequestEvent $event)
    {
        $request = $event->getRequest();
        $currentPort = $request->getPort();
        $restrictedRoute = '/testing/logging';
        $restrictedPort = 8080;

        if ($request->getPathInfo() === $restrictedRoute && $currentPort !== $restrictedPort) {
            $event->setResponse(new Response('This route is not accessible on this port', Response::HTTP_FORBIDDEN));
        }
    }
}

