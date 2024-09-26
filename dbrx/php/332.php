<?php
$password = 'your_password_here'; // replace with your password
$options = [
    'cost' => 12
];

$password_hash = password_hash($password, PASSWORD_BCRYPT, $options);

echo $password_hash;
?>