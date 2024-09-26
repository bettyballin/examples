<?php

class User implements \Symfony\Component\Security\Core\User\EquatableInterface
{
    public function getRoles()
    {
        return ['ROLE_USER'];
    }
}