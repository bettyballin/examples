
session_start();

if (!isset($_SESSION['user_id'])) {
    // User is not logged in, redirect them to login page or show an error
    header('Location: login.php');
    exit;
}

// The rest of your script that only logged-in users should see.

