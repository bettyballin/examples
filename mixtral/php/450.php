<?php
if ($login_ok) {
    include 'dashboard.php';
} else {
    header('Location: login.php');
    exit;
}
?>