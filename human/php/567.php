<?php 
if (empty($_SERVER['HTTP_X_REQUESTED_WITH'])) {
    header('Location: login.php'); // replace with your login page URL
    exit;
} else {
    header('Content-Type: application/json');
    echo json_encode(['warning' => 'X-Requested-With header is not empty']);
    exit;
}
?>