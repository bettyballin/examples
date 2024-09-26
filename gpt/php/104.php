
// controller.php
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    // Handle the unauthorized access
    die('Unauthorized access');
}

