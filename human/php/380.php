<?php
session_start();

if($_SESSION['loggedin'] !== true){
    header("Location: login.php");
    exit;
} else {
    // rest of protected page
}
?>