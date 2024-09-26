
// Your secret token
define('SECRET_TOKEN', 'your_secret_token');

// Check for the token in the request
if ($_SERVER['HTTP_X_SECRET_TOKEN'] !== SECRET_TOKEN) {
    // Token is not present or invalid, send a 403 Forbidden response
    header('HTTP/1.1 403 Forbidden');
    exit('Access denied');
}

// Rest of your PHP code

