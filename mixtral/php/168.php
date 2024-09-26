<?php

use JMS\SecurityExtraBundle\Annotation\Secure;

require 'vendor/autoload.php';

$kernel = new AppKernel('dev', true);
$kernel->boot();

$container = $kernel->getContainer();

$authorizationChecker = $container->get('security.authorization_checker');

if ($authorizationChecker->isGranted(new JMS\SecurityExtraBundle\Expression\Expression("hasRole('ROLE_ADMIN')"))) {
    echo "Enter";
} else {
    echo "Do not enter";
}