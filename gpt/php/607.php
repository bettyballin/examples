
function get_url($request_url, $secret_key) {
    $timestamp = time();
    $signature = hash_hmac('sha256', $timestamp . $request_url, $secret_key);

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $request_url);
    curl_setopt($ch, CURLOPT_HTTPHEADER, array(
        "X-Client-Signature: $signature",
        "X-Client-Timestamp: $timestamp"
    ));
    curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, 10);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
    $
