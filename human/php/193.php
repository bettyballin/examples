<?php
$pass = 'your_password_here';
$hash = hash('sha256', $pass);
$salt = substr(hash('sha256', mt_rand(0, 1337)), mt_rand(0, 31), 32);
$hash = $salt . hash('sha256', $salt . $hash . $pass);
echo $hash;
?>