<?php
$allowed_hosts = array('foo.example.com', 'bar.example.com');
if (!isset($_SERVER['HTTP_HOST']) || !in_array($_SERVER['HTTP_HOST'], $allowed_hosts)) {
    header($_SERVER['SERVER_PROTOCOL'].' 400 Bad Request');
    exit;
}
?>