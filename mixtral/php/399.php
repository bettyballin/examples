<?php

namespace App\EventListener;

use Symfony\Component\HttpKernel\Event\RequestEvent;
use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;

class RoleChangeListener
{
    private $tokenStorage;

    public function __construct(TokenStorageInterface $tokenStorage)
    {
        $this->tokenStorage = $tokenStorage;
    }

    public function onKernelRequest(RequestEvent $event): void
    {
        if (!$event->isMainRequest()) {
            return;
        }

        // Get the current user
        $user = $this->tokenStorage->getToken()->getUser();

        // Check for role changes
        if ($changedRoles = array_diff($user->getRoles(), session('roles'))) {
            // Update roles in session
            session(['roles' => $user->getRoles()]);

            // Refresh the user to update their permissions
            $this->tokenStorage->setToken(null);
        }
    }
}