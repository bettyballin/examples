
session_start();

if (!isset($_SESSION['user_id'])) { // Replace 'user_id' with the actual session variable you use
    header('Location: login.php');
    exit;
}

