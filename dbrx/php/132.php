<?php 
session_start();
if(!isset($_SESSION['page_1'])){
    header('Location: stage0.php');
    exit;
}
?>