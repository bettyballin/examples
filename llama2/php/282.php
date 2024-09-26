<?php

use Symfony\Component\Security\Core\EventListener\AuthenticationListenerInterface;
use Symfony\Component\Security\Core\Event\AuthenticationEvent;
use Symfony\Component\HttpFoundation\Request;

class CustomAuthenticationListener implements AuthenticationListenerInterface
{
    public function handle(AuthenticationEvent $event)
    {
        if ($event->getAuthenticationException() !== null) {
            $request = new Request($event->getRequest()->getAttributes());

            // Redirect to custom template
            $response = new \Symfony\Component\HttpFoundation\Response();
            $response->headers->set('Location', 'my_route');
            $response->setStatusCode(302);
            $event->setResponse($response);
        }
    }
}