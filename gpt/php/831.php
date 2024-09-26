
$ip = $_SERVER['REMOTE_ADDR']; // Get the client's IP address
$global_threshold = 1000; // Set a global threshold for large-scale attacks

// Check global failed attempts
$getGlobalFailedq = 'SELECT Count(*) AS failed FROM failed_logins WHERE attempted
