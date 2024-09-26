<?php

// Configuration file (make sure to create this file and define your settings)
// config.php:
// <?php
// // your configuration settings here
// ?>

require_once 'config.php';

// Start the session
session_start();

// Unset the user ID session variable
unset($_SESSION['user_id']);

// Redirect to the login page
header('Location: login.php');
exit;

?>