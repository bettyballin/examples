
$enc_data = mcrypt_encrypt(MCRYPT_3DES, $_key, $_data, MCRYPT_MODE_CBC, $_iv);
$base64_data = base64_encode($enc_data);
$url_safe_data = urlencode($base64_data);

// Append $url_safe_data to your URL as a GET parameter

