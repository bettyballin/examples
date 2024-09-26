<?php

use Symfony\Component\Security\Core\Authentication\Token\UsernamePasswordToken;

// Assuming you have a $user object and a container with a security token storage
$user = // retrieve your user object
$container = // retrieve your container

$token = new UsernamePasswordToken($user, null, 'main', $user->getRoles());
$container->get('security.token_storage')->setToken($token);

?>