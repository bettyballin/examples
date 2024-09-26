<?php
session_start();

if (!isset($_SESSION['user'])) {
    header("Location: login.php");
    ob_end_clean();
    exit;
}
?>