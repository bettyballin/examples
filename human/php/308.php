<?php

$password = 'your_password';
$salt = 'your_salt';

$result = $password . $salt;

for ($i = 0; $i < 10000000; $i++) {
    $result = hash('sha256', $result . $salt);
}

echo $result;

?>