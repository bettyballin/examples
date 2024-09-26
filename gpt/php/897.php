
session_start();

// Check if the user is logged in
if (!isset($_SESSION['user_id'])) {
    http_response_code(403);
    exit('Access denied.');
}

// Assuming $_SESSION['
