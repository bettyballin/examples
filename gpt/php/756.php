
list($timestamp, $hash) = explode(':', base64_decode($_POST['token']), 2);
$expectedHash = hash_hmac('sha256', $timestamp,
