<?php
session_start();
if($_SESSION['type']!=2){ 
    die("You are not a merchant. Access denied");
}

// The rest of your page here
?>