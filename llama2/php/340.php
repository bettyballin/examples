<?php

use Symfony\Component\Security\Csrf\CsrfToken;
use Symfony\Component\Security\Csrf\CsrfTokenBadge;

$csrfToken = new CsrfToken('login', 'your_csrf_token_value');
$badge = new CsrfTokenBadge('login', $csrfToken);

?>