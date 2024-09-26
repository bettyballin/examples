<?php

require __DIR__.'/vendor/autoload.php';

$app = new Silex\Application();

$app->register(new Silex\Provider\SecurityServiceProvider(array(
    'security.firewalls' => array(
        array(
            'pattern' => '/user',
            'form' => array(
                'login_path' => '/connexion',
                'check_path' => '/user'
            ),
            'users' => $app->share(function () use ($app) {
                return new Adh\Security\CustomUserProvider($app['db']);
            })
        )
    )
)));

$app->run();