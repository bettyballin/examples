
$allowed_referers = ['https://www.example.com', 'https://www.anotherdomain.com'];
$referer = $_SERVER['HTTP_REFERER'] ?? '';

if (!in_array(parse_url($referer, PHP_URL_HOST), $allowed_referers)) {
    // Handle unauthorized access
    exit
