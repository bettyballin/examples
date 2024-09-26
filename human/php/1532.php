<?php

use Symfony\Component\Security\Core\User\UserInterface;
use Lexik\Bundle\JWTAuthenticationBundle\Security\Authenticator\JWTTokenAuthenticator;

$container->loadFromExtension('security', [
    'firewalls' => [
        'react-api' => [
            'pattern' => '^/react-api',
            'anonymous' => true,
            'context' => 'main',
            'guard' => [
                'provider' => 'main',
                'authenticators' => [
                    JWTTokenAuthenticator::class,
                ],
            ],
        ],
        'main' => [
            'pattern' => '^/',
            'anonymous' => true,
        ],
    ],
]);