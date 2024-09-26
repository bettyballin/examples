<?php

$token = bin2hex(random_bytes(16));
$expiration = time() + (10 * 60); // 10 minutes
setcookie('token', $token, $expiration, '/');

?>