<?php
session_start();
if($_SESSION['is_logged_in'] == false) {
    header('Location: login.php'); 
    /* You can replace login.php to whatever page you want your 
       user to be redirected */
    exit;
}
?>