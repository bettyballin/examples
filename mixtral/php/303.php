<?php

use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;
use Symfony\Component\Security\Core\User\User;

$app['security.firewalls'] = [
    'admin' => [
        //...

        'users' => [
            $userFactory->create('admin', [
                'roles' => ['ROLE_ADMIN'],
                'password' => (new UserPasswordEncoderInterface())->encodePassword($userFactory->create('admin', ''), 'password')
            ])
        ]
    ]
];