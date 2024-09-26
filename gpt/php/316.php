
// An array of allowed origins
$allowed_origins = array(
    "https://example.com",
    "https://another-example.com"
);

// Check the origin of the request
$origin = isset($_SERVER['HTTP_ORIGIN']) ? $_SERVER['HTTP_ORIGIN'] : '';

// Only set the header if the origin is allowed
if (in_array($origin, $allowed_origins)) {
    header('Access-Control-Allow-Origin: ' . $origin);
}

// For JSONP requests, check the referer as there is no Origin header
if (isset($_SERVER['HTTP_REFERER'])) {
    $referer = parse_url($_SERVER['HTTP_REFERER'], PHP
