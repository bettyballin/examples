
// Allow requests from a specific domain
header('Access-Control-Allow-Origin: https://www.example.com');

// Allow requests from multiple specific domains
$allowed_domains = ['https://www.example.com', 'https://www.anotherdomain.com'];
if (in_array($_SERVER['HTTP_ORIGIN'], $allowed_domains)) {
    header('Access-Control-Allow-Origin: ' . $_SERVER['HTTP_ORIGIN']);
}

// Deny all cross-origin requests
header('Access-Control-Allow-Origin: none');

