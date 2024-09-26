<?php

use Symfony\Component\Security\Core\Exception\AccessDeniedException;
use Symfony\Component\Security\Http\Event\InteractiveLoginEvent;

class SecurityListener
{
    public function onSecurityInteractiveLogin(InteractiveLoginEvent $event)
    {
        // Get the User entity.
        $user = $event->getAuthenticationToken()->getUser();
        if ($user->getForcepasswordchange()) {
            throw new AccessDeniedException('You must change your password.');
        }
    }
}