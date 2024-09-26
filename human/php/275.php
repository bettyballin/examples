<?php
session_start();
if (!isset($_SESSION['logged_in']) || !$_SESSION['logged_in']) {
   header("Location: login.php");
   exit;
}
?>

<!-- // all code for page here -->