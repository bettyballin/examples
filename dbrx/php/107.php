<?php

require_once('Crypt/RSA.php');

function get_Url($request_url) {
    $rsa = new Crypt_RSA();
    $privatekey = file_get_contents('client_private.pem');
    $rsa->loadKey($privatekey);
    $signature = base64_encode($rsa->sign($request_url));

    $ch  = curl_init();
    curl_setopt($ch, CURLOPT_URL, $request_url . '&signature=' . urlencode($signature));
    curl_setopt($ch, CURLOPT_CONNECTTIMEOUT, 10);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
    $response  = curl_exec($ch);
    curl_close($ch);

    return $response;
}

$request_url ='http://localhost:8080/vb/dashboard/Marketing_dashboard/vb_server.php?function=somefunction';
$response = get_Url($request_url);

print_r($response);

?>