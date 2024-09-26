<?php

use Symfony\Component\DependencyInjection\Loader\Configurator\ContainerConfigurator;
use Symfony\Component\DependencyInjection\Reference;

return function (ContainerConfigurator $configurator) {
    $services = $configurator->services();

    $services->set('app.mail_service')
        ->class('AppBundle\Mail\MailService')
        ->arg(0, new Reference('mailer'))
        ->arg(1, new Reference('templating'));

    $services->set('app.doctrine.listener.user')
        ->class('AppBundle\EventListener\UserSubscriber')
        ->arg(0, new Reference('event_dispatcher'))
        ->tag('doctrine.event_subscriber', ['connection' => 'default']);

    $services->set('app.kernel.listener.user_registration_mail')
        ->class('AppBundle\EventListener\UserRegistrationMailSubscriber')
        ->arg(0, new Reference('app.mail_service'))
        ->tag('kernel.event_subscriber');
};