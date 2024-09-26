<?php

require_once __DIR__.'/vendor/autoload.php';

use Symfony\Component\Security\Core\Encoder\PlaintextPasswordEncoder;

$app = new Silex\Application();

// register this first
$app->register(new Silex\Provider\SecurityServiceProvider());

$app['security.default_encoder'] = function ($app) {
    // Plain text (e.g. for debugging)
    return new PlaintextPasswordEncoder();
};

$app->run();

?>