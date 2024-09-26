
session_start();

// Check if the user is logged in and is an admin
if (!isset($_SESSION['user_role']) || $_SESSION['user_role'] != 'admin') {
    // If the user is not an admin, show an error or redirect to a different page
    die('Access denied. You do not have permission to access this directory.');
}

// The rest of your code for admin users goes here
// ...

