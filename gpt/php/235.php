
session_start();

// Ensure the user is authenticated.
if (!isset($_SESSION['user_id'])) {
    die("You
