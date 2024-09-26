<?php

$password = 'mysecretpassword';
$hash     = password_hash($password, PASSWORD_DEFAULT);

// Store $hash in the db
echo $hash;