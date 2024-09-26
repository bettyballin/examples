<?php

$allowed_domains = ['yourdomain.com', 'www.yourdomain.com'];

if (!in_array(parse_url($_SERVER['HTTP_REFERER'], PHP_URL_HOST), $allowed_domains)) {
    header('HTTP/1.1 403 Forbidden');
    exit('Access denied.');
}

?>