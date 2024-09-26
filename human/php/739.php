<?php

namespace Acme\FooBundle;

use Symfony\Component\DependencyInjection\ContainerBuilder;
use Symfony\Component\DependencyInjection\Reference;

$container = new ContainerBuilder();

$container
    ->register('acme.config_provider', 'Acme\FooBundle\ConfigProvider')
    ->addArgument('%kernel.root_dir%');

$container
    ->register('acme.my_service', 'Acme\FooBundle\MyService')
    ->addArgument(new Reference('acme.config_provider'));

$container->setParameter('kernel.root_dir', __DIR__);

$configProvider = $container->get('acme.config_provider');
$myService = $container->get('acme.my_service');

var_dump($configProvider);
var_dump($myService);