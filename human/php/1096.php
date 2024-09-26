<?php

use Symfony\Component\Security\Core\Exception\AuthenticationException;

$session->set('_security.user_firewall.target_path', $request->getUri());

throw new AuthenticationException();