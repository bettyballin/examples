<?php
session_start();
if(!isset($_SESSION['userid'])) {
    header("location:main_login.html");
    exit;
}
?>