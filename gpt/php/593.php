
session_start();

// Define max login attempts and the lockout time in seconds
define('MAX_ATTEMPTS', 5);
define('LOCKOUT_TIME', 3600); // 1 hour

// Initialize the attempts if not set
if (!isset($_SESSION['attempts'])) {
    $_SESSION['attempts'] = 0;
    $_SESSION['last_attempt_time'] = time();
}

// Check if the user is locked out
if ($_SESSION['attempts'] >= MAX_ATTEMPTS && (time() - $_SESSION['last_attempt_time']) < LOCKOUT_TIME) {
    die('You are temporarily locked out. Please try again later.');
}

// Your existing code for FTP connection

// Inlog
