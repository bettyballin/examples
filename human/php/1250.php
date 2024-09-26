<?php

use Symfony\Component\Security\Core\User\InMemoryUserProvider;
use Symfony\Component\Security\Core\User\User;

$container->setParameter('your_parameter_key', 'your_password');

$container->loadFromExtension('security', [
    'providers' => [
        'in_memory' => [
            'memory' => [
                'users' => [
                    'user1' => [
                        'password' => '%your_parameter_key%',
                        'roles' => ['ROLE1'],
                    ],
                ],
            ],
        ],
    ],
]);

$provider = new InMemoryUserProvider([
    'user1' => [
        'password' => $container->getParameter('your_parameter_key'),
        'roles' => ['ROLE1'],
    ],
]);

$user = new User('user1', $provider->loadUserByUsername('user1')->getPassword(), $provider->loadUserByUsername('user1')->getRoles());

$container->get('security.context')->setToken(new \Symfony\Component\Security\Core\Authentication\Token\UsernamePasswordToken($user, $user->getPassword(), 'provider', $user->getRoles()));