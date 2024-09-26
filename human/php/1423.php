<?php

use Symfony\Component\Security\Core\User\EquatableInterface;
use Symfony\Component\Security\Core\User\UserInterface;

class User implements EquatableInterface
{
    private $enabled;
    private $passwordHash;

    public function __construct($enabled, $passwordHash)
    {
        $this->enabled = $enabled;
        $this->passwordHash = $passwordHash;
    }

    public function isEqualTo(UserInterface $user)
    {
        if (!$user instanceof User) {
            return false;
        }

        if ($this->enabled !== $user->enabled) {
            return false;
        }

        if ($this->passwordHash !== $user->passwordHash) {
            return false;
        }

        return true;
    }

    public function getEnabled()
    {
        return $this->enabled;
    }

    public function getPasswordHash()
    {
        return $this->passwordHash;
    }
}

// Example usage:
$user1 = new User(true, 'password_hash_1');
$user2 = new User(true, 'password_hash_1');
$user3 = new User(false, 'password_hash_2');

var_dump($user1->isEqualTo($user2)); // bool(true)
var_dump($user1->isEqualTo($user3)); // bool(false)