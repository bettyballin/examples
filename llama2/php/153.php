<?php
session_start();

// When user logs in
$_SESSION['secure'] = true;

// On every page load
if(isset($_SESSION['secure'])) {
    if(!isset($_SERVER['HTTPS']) || $_SERVER['HTTPS'] != 'on') {
        header('Location: https://' . $_SERVER['SERVER_NAME'] . $_SERVER['REQUEST_URI']);
        exit;
    }
}
?>