
$userAgent = $_SERVER['HTTP_USER_AGENT'];
if (strpos($userAgent, "Android") !== false) {
    // Likely an Android device
} else {
    // Access denied
    http_response_code(403); // Forbidden
    exit;
}

