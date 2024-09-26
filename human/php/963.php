<?php

class MyClass {
    private $container;

    public function __construct($container) {
        $this->container = $container;
    }

    public function clearCookie() {
        $cookieName = $this->container->getParameter('framework.session.name');
        $response = new \Symfony\Component\HttpFoundation\Response();
        $response->headers->clearCookie($cookieName);
        return $response;
    }
}

$container = new \Symfony\Component\DependencyInjection\ContainerBuilder();
$container->setParameter('framework.session.name', 'my_session_name');

$myClass = new MyClass($container);
$response = $myClass->clearCookie();

print_r($response->headers);