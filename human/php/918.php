<?php

class SecurityContext {
    public function isGranted($role) {
        // Simulating the isGranted method
        return $role === 'ROLE_ADMIN';
    }
}

class Container {
    private $services = [];

    public function set($id, $service) {
        $this->services[$id] = $service;
    }

    public function get($id) {
        return $this->services[$id];
    }
}

$container = new Container();
$securityContext = new SecurityContext();
$container->set('security.context', $securityContext);

class MyClass {
    private $container;

    public function __construct(Container $container) {
        $this->container = $container;
    }

    public function get($id) {
        return $this->container->get($id);
    }
}

$myClass = new MyClass($container);

if ($myClass->get('security.context')->isGranted('ROLE_ADMIN')) {
    echo "Enter";
} else {
    echo "Do not enter";
}