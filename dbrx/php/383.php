<?php

use Psr\Container\ContainerInterface;

class MyClass
{
    public function __construct(ContainerInterface $container)
    {
        // ...
    }
}

// Example usage:
$container = new \Psr\Container\ContainerInterface(); // Replace with actual container implementation
$myClass = new MyClass($container);