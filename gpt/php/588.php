
if (isset($_SERVER['HTTP_REFERER'])) {
    $referrer = $_SERVER['HTTP_REFERER'];
    // Validate that the referrer is your own domain.
    if (parse_url($referrer, PHP_URL_HOST) != parse_url('http://www.yourdomain.com', PHP_URL_HOST)) {
        // Handle the case where the referrer is not your own site.
        die('Invalid referrer!');
    }
} else {
    // Handle the case where the HTTP_REFERER is not set.
    die('No referrer!');
}

