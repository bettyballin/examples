<?php

class User {
    private $username;
    private $salt;
    private $password;

    public function setUsername($username) {
        $this->username = $username;
    }

    public function setSalt($salt) {
        $this->salt = $salt;
    }

    public function getPassword() {
        return $this->password;
    }

    public function getSalt() {
        return $this->salt;
    }

    public function setUsernameAttr($username) {
        $this->setUsername($username);
    }

    public function setPassword($password) {
        $this->password = $password;
    }
}

class Sha256SaltedEncoder {
    public function getEncoder($user) {
        return $this;
    }

    public function encodePassword($password, $salt) {
        return hash('sha256', $password . $salt);
    }
}

class Container {
    public function get($service) {
        if ($service == 'acme.test.sha256salted_encoder') {
            return new Sha256SaltedEncoder();
        }
    }
}

$container = new Container();

// Add a new User
$user = new User();
$user->setUsernameAttr('username');
$user->setSalt(uniqid(mt_rand())); // Unique salt for user

// Set encrypted password
$encoder = $container->get('acme.test.sha256salted_encoder')
  ->getEncoder($user);
$password = $encoder->encodePassword('MyPass', $user->getSalt());
$user->setPassword($password);

print_r($user);