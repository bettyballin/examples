<?php

namespace App\EventListener;

use Symfony\Component\HttpKernel\Event\FilterResponseEvent;

class LoginListener
{
    public function onKernelResponse(FilterResponseEvent $event)
    {
        // Get the current request
        $request = $event->getRequest();

        if ($request->getPathInfo() === '/api/login') {
            // Log user login event here

            // Example:
            // $this->loggerService->logUserLogin($user);

            return;
        }
    }
}