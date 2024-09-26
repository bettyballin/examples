<?php
$url = $_SERVER['REQUEST_URI'];

if ($url == '/') {
    echo "Homepage";
} else if (is_numeric(substr($url, 1))) {
    echo "Post with ID " . substr($url, 1);
} else {
    http_response_code(404);
    echo "404 Page Not Found";
}
?>