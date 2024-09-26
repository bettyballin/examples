<?php

use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;

class MyClass
{
    private $container;

    public function __construct($container)
    {
        $this->container = $container;
    }

    public function checkRole($role)
    {
        $authorizationChecker = $this->container->get('security.authorization_checker');
        return $authorizationChecker->isGranted($role);
    }
}

$container = new \Symfony\Component\DependencyInjection\ContainerBuilder();
$container->register('security.authorization_checker', \Symfony\Component\Security\Core\Authorization\AuthorizationChecker::class);

$myClass = new MyClass($container);
$role = 'ROLE_ADMIN';
var_dump($myClass->checkRole($role));