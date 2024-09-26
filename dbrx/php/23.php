<?php

function ssl_installed() {
    if (!isset($_SERVER['HTTPS']) || $_SERVER['HTTPS'] != 'on') {
        $headers = apache_request_headers();
        return isset($headers['X-Forwarded-Proto']) && $headers['X-Forwarded-Proto'] == 'https';
    }
    return true;
}

$result = ssl_installed();

if($result) {
    echo "SSL is installed.";
} else {
    echo "SSL is not installed.";
}