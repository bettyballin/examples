<?php

use Symfony\Component\Routing\RouteCollection;
use Symfony\Component\Routing\Route;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Authentication\Token\PreAuthenticatedToken;
use Symfony\Component\Security\Core\Exception\AuthenticationException;
use Symfony\Component\Security\Core\User\UserInterface;
use Symfony\Component\Security\Core\User\UserProviderInterface;

// routing.php
$routes = new RouteCollection();

$routes->add('login_route_name', new Route('/{_locale}/login', [
    '_locale' => 'en',
    '_controller' => 'app.controller_service.security:login',
]));

$routes->add('login_check_route_name', new Route('/{_locale}/login/check', [
    '_locale' => 'en',
    '_controller' => 'app.controller_service.security:loginCheck',
]));

// security.php
$config = [
    'security' => [
        'firewalls' => [
            'firewall_name' => [
                'form_login' => [
                    'login_path' => 'login_route_name',
                    'check_path' => 'login_check_route_name',
                ],
            ],
        ],
    ],
];

// controller.php
namespace App\Controller\Service\Security;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;

class SecurityController
{
    public function login(Request $request)
    {
        // login logic here
    }

    public function loginCheck(Request $request)
    {
        // login check logic here
    }
}