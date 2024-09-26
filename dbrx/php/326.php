<?php

// Define allowed API keys here.
$allowed_api_keys = array('your_secret_key');

if (isset($_GET['api_key']) && in_array($_GET['api_key'], $allowed_api_keys)) {
    // Access granted proceed with the request and return data.
    echo "Access granted!";

} else {
    // Invalid or missing api_key. Return an error message or deny access.
    http_response_code(401);
    echo "Invalid or missing API key.";
}

?>