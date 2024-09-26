<?php
session_start();

// Assuming you have already set the 'can_delete' session variable somewhere in your code
// For demonstration purposes, I'll set it here
$_SESSION['can_delete'] = true; // or false

if($_SESSION['can_delete'] != true){ 
    die('Insufficient Privileges'); 
}
?>