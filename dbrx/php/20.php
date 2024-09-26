<?php

function validate_token($token) {
    // Your token validation logic here
    // For example:
    $valid_tokens = array('token1', 'token2');
    return in_array($token, $valid_tokens);
}

$token = $_GET['token'];

if (!validate_token($token)) {
    header('HTTP/1.1 401 Unauthorized');
    echo 'Access denied!';
    exit;
}

// Token is valid, proceed with the rest of the script
echo 'Token is valid!';

?>