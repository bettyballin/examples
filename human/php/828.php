<?php

use Symfony\Component\DependencyInjection\Reference;

$container->register('sdz_user.custom_encoder', 'Sdz\UserBundle\Security\Encoder\CustomEncoder')
    ->addArgument(new Reference('doctrine'));