<?php
function cryptojsBase64($input) {
    $output = base64_encode(openssl_digest($input, 'md5', true));

    // Replace non-alphanumeric characters with the RFC 4648 Basic variant
    return strtr($output, '+/=', '-_');
}

$str = "hello";
echo cryptojsBase64($str);
?>