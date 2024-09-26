<?php
$allowed_ips = array('123.456.789.000', '000.000.000.000'); 

if (!in_array($_SERVER['REMOTE_ADDR'], $allowed_ips)) {
    header("Location: https://www.google.com/");
    die('We are sorry but we are going have to stop you there! A link to Google.');
}
?>