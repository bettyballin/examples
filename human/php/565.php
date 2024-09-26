<?php 
if (empty($_SERVER['HTTP_REFERER'])) {
    header('Location: login.php');
    exit;
} else {
    header('Content-Type: application/json');
    echo '{"warning": "Referer not empty"}';
}
?>