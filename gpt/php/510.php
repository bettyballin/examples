
if (php_sapi_name() !== 'cli') {
    http_response_code(403); // Forbidden
    exit;
}

