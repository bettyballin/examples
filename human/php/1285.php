<?php
$userData = array('salt' => 'your_salt_here');
$password = 'your_password_here';

$hash = hash('sha256', $userData['salt'] . $password);

print($hash);
?>