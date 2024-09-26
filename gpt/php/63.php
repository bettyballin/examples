
if (isset($_SERVER['HTTP_ORIGIN'])) {
    $allowed_domains = ['https://www.yourdomain.com', 'https://sub.yourdomain.com'];
    if (in_array($_SERVER['HTTP_ORIGIN'], $allowed_domains)) {
        header('Access-Control-Allow-Origin: ' . $_SERVER['HTTP_ORIGIN']);
    } else {
        // Origin not allowed
        exit;
    }
} elseif (isset($_SERVER['HTTP_REFERER'])) {
    $referer_domain = parse_url($_SERVER['HTTP_REFERER'], PHP_URL_HOST);
    $allowed_domains = ['www.yourdomain.com', 'sub.yourdomain.com'];
    if (in_array($referer_domain, $allowed_domains)) {
        // Referer is from an allowed domain
    } else {
        // Referer is not allowed
        exit;
    }
} else {
