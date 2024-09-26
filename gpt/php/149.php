
session_start();

// Check if the user is logged in
if (!isset($_SESSION['user_id'])) {
    // Redirect to login page or show an error
    header('Location: login.php');
    exit;
}

$user_id = $_SESSION['user_id'];
$page_id = $_GET['pageid'];

// Now, you must verify if the user has permission to edit the event with page_id
// This often requires a database query to check the association between the user and the page.

// Create a
