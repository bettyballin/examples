<?php

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\RedirectResponse;

$app['security.firewalls'] = [
    // ...
];

$app->before(function (Request $request) use ($app) {
    if ('/admin/' === substr($request->getPathInfo(), 0, strlen('/admin')) && !$app['security.authorization_checker']->isGranted('ROLE_ADMIN')) {
        return new RedirectResponse($app['url_generator']->generate('login'));
    }
});

$app['security.access_rules'] = [
    ["^/admin", "ROLE_ADMIN"]
];

?>