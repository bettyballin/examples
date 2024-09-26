<?php
session_start();                  // Start the session
if (!isset($_SESSION["admin"])) { // If session not registered
    header("location:login.php"); // Redirect to login.php page
    exit;                         // Stop execution of current script
} else {
    header('Content-Type: text/html; charset=utf-8');
    define('ADMIN', $_SESSION["name"]); //Get the user name from the previously registered super global variable
}
?>