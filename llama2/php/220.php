<?php

// Assuming Symfony framework is being used

use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\User\UserInterface;

class AcmeController
{
    private $tokenStorage;

    public function __construct(TokenStorageInterface $tokenStorage)
    {
        $this->tokenStorage = $tokenStorage;
    }

    public function AcmeAction()
    {
        $token = $this->tokenStorage->getToken();
        $user = $token->getUser();
        $user->setRole('ROLE_ADMIN');
        // ...
    }
}