
<?php

// Check if the HTTP_REFERER is set and contains your site's domain
if (isset($_SERVER['HTTP_REFERER']) && (parse_url($_SERVER['HTTP_REFERER'], PHP_URL_HOST) == 'your-domain.com')) {
    // Generate the CAPTCHA image here
} else {
    // Handle the direct access case
    header('HTTP/1.0 403 Forbidden');
    echo "You are not allowed to access this file directly.";
    exit;
}

