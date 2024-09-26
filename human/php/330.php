<?php

use Symfony\Component\Security\Core\Encoder\MessageDigestPasswordEncoder;
use Symfony\Component\Security\Core\User\UserInterface;

class Sha256SaltedEncoder extends MessageDigestPasswordEncoder
{
    public function __construct()
    {
        parent::__construct('sha256', true, 1);
    }
}

class User implements UserInterface
{
    private $username;
    private $password;
    private $salt;

    public function __construct($username, $password, $salt)
    {
        $this->username = $username;
        $this->password = $password;
        $this->salt = $salt;
    }

    public function getUsername()
    {
        return $this->username;
    }

    public function getSalt()
    {
        return $this->salt;
    }

    public function getPassword()
    {
        return $this->password;
    }

    public function getRoles()
    {
        return array();
    }

    public function eraseCredentials()
    {
    }
}

$encoder = new Sha256SaltedEncoder();
$user = new User('test', 'test', 'salt');

$encodedPassword = $encoder->encodePassword($user->getPassword(), $user->getSalt());

print $encodedPassword;