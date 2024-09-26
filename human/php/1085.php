<?php

use Symfony\Component\DependencyInjection\Definition;
use Symfony\Component\DependencyInjection\Reference;

$definition = new Definition('EventListenerBundle\EventListener\TokenListener', [
    new Reference('doctrine.orm.entity_manager'),
    new Reference('security.token_storage'),
    new Reference('templating'),
    new Reference('router'),
    new Reference('controller_resolver'),
]);

$definition->addTag('kernel.event_listener', [
    'event' => 'kernel.request',
    'method' => 'onKernelRequest',
]);

$container->setDefinition('app.tokens.action_listener', $definition);