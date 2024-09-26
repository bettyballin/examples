<?php
session_start();
if (!isset($_SESSION['id'])){
    header('HTTP/1.0 403 Forbidden');
    echo "Sorry, access not granted!";
    exit;
}
?>

<html>...