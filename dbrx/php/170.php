<?php

use Symfony\Component\Security\Core\Role\Role;
use Symfony\Component\Security\Core\SecurityContext;

$securityContext = new SecurityContext();

if ($securityContext->isGranted(array(new Role('ROLE_ADMIN')))) {
    echo "Enter";
} else  {
    echo "Do not enter";
}