
<?php
// Get the referer
$referer = $_SERVER['HTTP_REFERER'];

// Check if the referer is from your own domain
if (strpos($referer, 'abc.xyz') !== false) {
    // The referer is from your own domain, allow access
    // Your PHP code here
} else {
    // The referer is not from your own domain or not provided, deny access
    http_response_code(403); // Forbidden
    exit('No direct script access allowed');
}
?>

