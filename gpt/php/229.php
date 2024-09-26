
// Start the session
session_start();

// ... your code to check user credentials
if ($login_successful) {
    $_SESSION['username'] = $username; // Store the username in the session
    // Redirect to admin page
    header('Location: admin.php');
    exit;
}

