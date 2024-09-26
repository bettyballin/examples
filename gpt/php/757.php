
function pem2der($pem_data) {
    $begin = "-----BEGIN PUBLIC KEY-----";
    $end   = "-----END PUBLIC KEY-----";
    $pem_data = substr($pem_data, strpos($pem_data, $begin) + strlen($begin));
    $pem_data = substr($pem_data, 0, strpos($pem_data, $end));
    $der = base64_decode($pem_data);
    return $der;
}

// Get public key in DER format
$der = pem2der($pubKey);

