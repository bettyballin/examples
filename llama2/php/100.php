<?php
$storedToken = 'your_token_here'; // replace with your stored token

if (isset($_SERVER['HTTP_TOKEN']) && $_SERVER['HTTP_TOKEN'] === $storedToken) {
    // Update DB...
    echo "Token is valid. Updating DB...\n";
} else {
    // Return error or ignore request
    echo "Invalid token. Request ignored.\n";
}
?>