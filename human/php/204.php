<?php

$password = 'your_password_here';
$salt = 'IQRaTwmf';
$rounds = 11;

$hash = crypt($password, sprintf('$P$%02d%s', $rounds, $salt));

print($hash . "\n");

?>