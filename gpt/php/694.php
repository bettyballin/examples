
function php_dec($iv, $key, $encrypted) {
    $method = 'aes-128-cbc';
    $key = base64_decode($key);
    $iv =
