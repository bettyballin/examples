
session_start();

// Check if the 'username' session variable is set, which indicates the user is logged in
if (isset($_SESSION['username'])) {
    // Sanitize the username before displaying to avoid XSS attacks
    $username = htmlspecialchars($_SESSION['username'], ENT_QUOTES, 'UTF-8');
    echo "Welcome, <a href='account_settings.php'>$username</a>!";
} else {
    echo "<a href='login.php'>Please Login</a>";
}

