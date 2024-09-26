
session_start();

// Function to validate the session token or referrer
function isValidRequest() {
    // Check if the session token is valid or if the referrer is from your own domain
    if (isset($_SESSION['is_authorized']) && $_SESSION['is_authorized']
