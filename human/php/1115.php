<?php

$email_token = openssl_random_pseudo_bytes(16);
$token = bin2hex($email_token);

print($token);

?>