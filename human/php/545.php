<?php

$password = 'password';

// 5000 rounds
$salt = 'salt';
$hashed_password_1 = crypt($password, '$6$rounds=5000$' . $salt . '$');

// 2500 rounds
$hashed_password_2 = crypt($password, '$6$rounds=2500$' . $salt . '$');

// 2500 rounds again
$hashed_password_3 = crypt($password, '$6$rounds=2500$' . $salt . '$');

print($hashed_password_1 . "\n");
print($hashed_password_2 . "\n");
print($hashed_password_3 . "\n");

?>