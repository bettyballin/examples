
session_start(); // Start the session.

function isLoggedIn() {
    return isset($_SESSION['user_id']);
}

if (isLoggedIn()) {
    echo "The user is already logged in.";
    // Proceed with user-specific functionality.
} else {
    echo "Please log in.";
    // Redirect to login page or show login form.
}

