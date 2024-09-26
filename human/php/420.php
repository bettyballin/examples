<?php

function my_openssl_sign($data, &$signature, $priv_key_id, $signature_alg = 'sha256WithRSAEncryption') {
    $pinfo = openssl_pkey_get_details($priv_key_id);
    $hash = hash('sha256', $data);
    $t = '3031300d060960864801650304020105000420'; # sha256
    $t .= $hash;
    $pslen = $pinfo['bits']/8 - (strlen($t)/2 + 3);

    $eb = '0001' . str_repeat('FF', $pslen) . '00' . $t;
    $eb = pack('H*', $eb);

    return openssl_private_encrypt($eb, $signature, $priv_key_id, OPENSSL_NO_PADDING);
}

$priv_key = openssl_pkey_get_private('file://path/to/your/private/key.pem');
$data = 'Hello, World!';
$signature = '';
my_openssl_sign($data, $signature, $priv_key);

echo "Signature: " . bin2hex($signature) . "\n";

?>