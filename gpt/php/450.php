
$secret = "secret";
$timestamp = "2012-10-01T17:48:56";
$hmac = hash_hmac("sha256", $timestamp, $secret, true); // The 'true' parameter will return raw binary data
$base64_encoded_hmac = base64_encode($hmac);
echo $base64_encoded_hmac;

