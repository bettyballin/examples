<?php
// Get the requested page from the URI
$page = trim(parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH), '/');

// Validate the page parameter using a regular expression
if (preg_match('/^[a-zA-Z0-9\/_-]+$/', $page)) {
    // Define allowed paths
    $allowedPaths = array('./');

    // Sanitize the page parameter
    $page = realpath($allowedPaths[0] . $page);

    // Check if the page exists and is in the allowed paths
    if ($page && in_array(dirname($page), $allowedPaths)) {
        // Include the requested page
        include($page . '.php');
    } else {
        // Invalid page parameter
        echo 'Invalid page request';
    }
} else {
    // Invalid page parameter
    echo 'Invalid page request';
}
?>