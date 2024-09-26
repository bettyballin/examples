
session_start();

// Define your lockout parameters
$maxAttempts = 5;
$lockoutDuration = 5 * 60; // 5 minutes in seconds

// Initialize session variables if not set
if (!isset($_SESSION['login_attempts'])) {
    $_SESSION['login_attempts'] = 0;
}
if (!isset($_SESSION['lockout_time'])) {
    $_SESSION['lockout_time'] = 0;
}

// Function to check if the user is locked out
function isUserLockedOut() {
    if (time() < $_SESSION['lockout_time']) {
        return true;
   
