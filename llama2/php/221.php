<?php

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

        if ($user instanceof UserInterface) {
            $user->setRole('ROLE_ADMIN');
        }

        // ...
    }
}

class User implements UserInterface
{
    private $roles = [];

    public function setRole($role)
    {
        $this->roles[] = $role;
    }

    public function getRoles()
    {
        return $this->roles;
    }

    public function getPassword()
    {
        // ...
    }

    public function getSalt()
    {
        // ...
    }

    public function getUsername()
    {
        // ...
    }

    public function eraseCredentials()
    {
        // ...
    }
}