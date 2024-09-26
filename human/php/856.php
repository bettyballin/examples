<?php
// This is not PHP code, it's Nginx configuration.
// However, I will provide the equivalent PHP code:

$uri = $_SERVER['REQUEST_URI'];

if (preg_match('#/(dir1|dir2|dir3)#', $uri)) {
    http_response_code(404);
    echo 'Not Found';
    exit;
}