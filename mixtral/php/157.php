<?php

use Symfony\Component\Security\Core\Exception\AccessDeniedException;
use Symfony\Component\Security\Core\Authorization\AuthorizationCheckerInterface;

$securityContext = $this->get('security.authorization_checker');

// Option 1
$this->denyAccessUnlessGranted('ROLE_ADMIN', null, 'Unable to access this page!');

// Option 2
if (!$securityContext->isGranted('ROLE_USER')) {
    throw new AccessDeniedException();
}