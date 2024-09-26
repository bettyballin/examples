<?php
/*
Order deny, allow
Deny from all

Allow from 127.0.0.1
Allow from 192.168.1.13
*/

$allowed_ips = array('127.0.0.1', '192.168.1.13');

if (!in_array($_SERVER['REMOTE_ADDR'], $allowed_ips)) {
    header('HTTP/1.1 403 Forbidden');
    exit('Access denied');
}
?>