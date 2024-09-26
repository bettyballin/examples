<?php
session_start();

if(!isset($_SESSION['userId']) || !$_SESSION['isAdmin']){
    session_regenerate_id();
    header('Strict-Transport-Security: max-age=31536000; includeSubDomains');
    header("Location: login");
    exit;
}
?>