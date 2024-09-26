<?php
function filter_url($url) {
    $allowed_chars = 'a-zA-Z0-9_\\-\\/\\.\\?=&';
    $url = preg_replace("/[^$allowed_chars]+/", '', $url);
    $url = urlencode($url);
    return $url;
}

$url = "https://example.com/path?param=value";
echo filter_url($url);
?>