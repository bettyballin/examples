<?php

class SecurityContext {
    public function isGranted($role) {
        // Your logic to check if the user has the given role
        // For demonstration purposes, it always returns true
        return true;
    }
}

class Container {
    private $services;

    public function __construct() {
        $this->services = [];
    }

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

$class = new class($container) {
    private $container;

    public function __construct(Container $container) {
        $this->container = $container;
    }

    public function execute() {
        if ($this->container->get('security.context')->isGranted('IS_AUTHENTICATED_REMEMBERED')) {
            print('Access granted');
        } else {
            print('Access denied');
        }
    }
};

$class->execute();