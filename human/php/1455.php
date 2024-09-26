<?php

// services.php

use Symfony\Component\DependencyInjection\Reference;

$services = new \Symfony\Component\DependencyInjection\ContainerBuilder();

$services
    ->set(FooSubscriber::class)
    ->addArgument(new Reference('security.firewall.map'));