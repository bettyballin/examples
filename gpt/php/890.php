
$allowedDomainPattern = '/^https?://(.+\.)?my-site\.com$/';
$origin = isset($_SERVER['HTTP_ORIGIN']) ? $_SERVER['HTTP_ORIGIN'] : '';

if (preg_match($allowedDomainPattern, $origin)) {
    header('Access-Control-Allow-Origin: ' . $origin);
    header('Vary: Origin');
}

