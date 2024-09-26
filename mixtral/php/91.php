<?php

require 'vendor/autoload.php';

use Silex\Application;
use Silex\Provider\SecurityServiceProvider;
use Adh\Security\User;
use Adh\Security\CustomPasswordEncoder;
use Symfony\Component\Security\Core\Encoder\EncoderFactory;

$app = new Application();

$app->register(new SecurityServiceProvider(array(
    'security.encoder_factory' => $app->share(function ($app) {
        return new EncoderFactory([
            User::class => new CustomPasswordEncoder()
        ]);
    })
)));

$app->run();