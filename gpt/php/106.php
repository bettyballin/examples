
// controller.php
session_start();
if (empty($_SESSION['token']) || $_SESSION['token'] !== $_POST['token']) {
    die('Unauthorized access');
}

