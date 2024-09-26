<?php

function get_client_ip() {
    $allowed_headers = [
        'HTTP_CLIENT_IP',
        'HTTP_X_FORWARDED_FOR',
        'HTTP_X_REAL_IP',
        'HTTP_CF_CONNECTING_IP'
    ];

    foreach ($allowed_headers as $header) {
        if (isset($_SERVER[$header])) {
            return $_SERVER[$header];
        }
    }

    // Fallback to REMOTE_ADDR
    return isset($_SERVER['REMOTE_ADDR']) ? $_SERVER['REMOTE_ADDR'] : '';
}

$ip = get_client_ip();

if (!filter_var($ip, FILTER_VALIDATE_IP)) {
    die('Invalid IP address');
}

echo "Your IP address is: $ip";

?>