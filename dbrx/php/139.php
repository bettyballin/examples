<?php
$allowed_ip = '123.456.789.012'; // replace with your actual allowed IP

if ($_SERVER['REMOTE_ADDR'] !== $allowed_ip) {
    header('Location: https://www.google.com');
    exit('We are sorry but we have to stop you there!');
}
?>