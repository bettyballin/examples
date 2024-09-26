<?php

$app->before(function (\Symfony\Component\HttpFoundation\Request $request) use ($app) {
    // This won't work with Symfony Security Component < 2.6
    // $authAnon = $app['security']->isGranted('IS_AUTHENTICATED_ANONYMOUSLY');

    // Under Symfony 2.6+
    $authAnon = $app['security.authorization_checker']->isGranted('IS_AUTHENTICATED_ANONYMOUSLY');
    // ...
});