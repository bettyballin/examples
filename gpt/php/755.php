
$secretKey = 'your_private_key';
$timestamp = time(); // Server time
$hash = hash_hmac('sha256', $timestamp, $secretKey);
$token = base64_encode($timestamp . ':' . $hash);

