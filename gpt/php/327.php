
session_start();

// Check if the user is logged in
if (!isset($_SESSION['loggedIn']) || $_SESSION['loggedIn'] !== true) {
    header('Location: login_page.php'); // Redirect to login page
    exit;
}

// Check if the user is a merchant
if ($_SESSION['userPermission'] != 1) { // Assuming 1 is the permission level for merchants
    // If the user is not a merchant, redirect them away or show an error
    header('Location: unauthorized_access
