<?php
$password = 'your_password_here';
$userData = array('salt' => 'your_salt_here');

$hash = hash('sha256', $userData['salt'] . hash('sha256', $password));

print($hash);
?>