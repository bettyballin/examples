
function encryptAES($text, $key)
{
    $keyBytes = base64_decode($key);
    $encrypt = openssl
