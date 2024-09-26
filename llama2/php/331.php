<?php
session_start();

if (isset($_GET['token']) && isset($_SESSION['token']) && $_SESSION['token'] === $_GET['token']) {
    // proceed with display/actions
} else {
    header("Location: index.php?error=csrf_token_invalid");
    exit;
}
?>