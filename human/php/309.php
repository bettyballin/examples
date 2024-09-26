<?php
$password = 'your_password';
$salt = 'your_salt';

$hash = crypt($password, '$2a$07$' . $salt . '$');

print($hash);
?>