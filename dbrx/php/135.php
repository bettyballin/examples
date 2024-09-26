<?php
session_start();
$userdata = array(
    'username' => 'JohnDoe',
    'email' => 'johndoe@example.com',
);
session_regenerate_id();
$_SESSION['user'] = $userdata;
print_r($_SESSION);
?>