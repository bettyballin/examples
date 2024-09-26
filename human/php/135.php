<?php

$username = 'test_user';
$ip = $_SERVER['REMOTE_ADDR'];

$hash = md5($username.$ip);

print($hash);

?>