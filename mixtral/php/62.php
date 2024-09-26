<?php

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, "https://msgtest.bankserv.co.za/maps/txns.asp");
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
$request = ''; // Define your $request variable here
curl_setopt($ch, CURLOPT_POSTFIELDS, $request);
$response = curl_exec($ch);
if (curl_errno($ch)) {
    echo 'Error:' . curl_error($ch);
}
curl_close ($ch);

?>