
<?php
// standalone.php

require_once __DIR__.'/../app/bootstrap.php.cache';
require_once __DIR__.'/../app/AppKernel.php';

use Symfony\Component\HttpFoundation\Request;

$kernel = new AppKernel('prod', false);  // Use 'dev' or 'prod' as appropriate
$kernel->boot();

// Get the container and start the session
$container = $kernel->getContainer();
$container->get('session')->start();

// Get the security context
$securityContext = $container->get('security.authorization_checker');

// Check if the user is logged in
if ($securityContext->isGranted('IS_AUTHENTICATED_FULLY')) {
    // The user
