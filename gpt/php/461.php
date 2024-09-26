
session_start(); // Start the session at the beginning of each script

// Check if the user is logged in
if (!isset($_SESSION['user_id'])) {
    // Redirect the user to the login page
   
