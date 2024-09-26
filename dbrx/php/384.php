<?php

class Example {
    private $maintenance;

    public function __construct(Container $container) {
        $this->maintenance = $container->hasParameter('maintenance') ? $container->getParameter('maintenance') : false;
        // etc...
    }
}

class Container {
    private $parameters;

    public function __construct(array $parameters) {
        $this->parameters = $parameters;
    }

    public function hasParameter($name) {
        return array_key_exists($name, $this->parameters);
    }

    public function getParameter($name) {
        return $this->parameters[$name];
    }
}

$container = new Container(['maintenance' => true]);
$example = new Example($container);