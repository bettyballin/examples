<?php

use Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorageInterface;

class MyClass
{
    private $tokenStorage;

    public function __construct(TokenStorageInterface $tokenStorage)
    {
        $this->tokenStorage = $tokenStorage;
    }
}