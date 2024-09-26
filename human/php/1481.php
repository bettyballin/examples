public static function CalculateSignature($method, $nonce, $postdata, $secret)
{
    // Encoding
    $methodBytes = '/' . $method;
    $noncePostdataBytes = $nonce . $postdata;
    $secretBytes = base64_decode($secret);

    // $hash = '/' . $method . hash('sha256', $nonce . $postdata, true);
    $nonceHash = hash('sha256', $noncePostdataBytes, true);
    $hash = $methodBytes . $nonceHash;

    // $signature = hash_hmac('sha512', $hash, base64_decode($secret), true);
    $signature = hash_hmac('sha512', $hash, $secretBytes, true);

    // $signature = base64_encode($signature);
    $signatureB64 = base64_encode($signature);

    return $signatureB64;
}