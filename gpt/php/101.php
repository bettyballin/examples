
session_start();
ob_start();

if (!isset($_SESSION['user'])) {
    header("Location: login.php");
    ob_end_flush(); // Flush the buffer and turn off output buffering
    exit;           // This will stop the script execution
}

// Protected content
// ...

ob_end_flush();

