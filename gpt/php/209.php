
session_start();
if (!isset($_SESSION['logged_in']) || $_SESSION['logged_in'] !== true) {
    // Redirect to login page or send an error message.
    exit('Access denied. You must be logged in to download files.');
}

