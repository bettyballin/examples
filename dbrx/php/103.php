<?php

$data = array("message" => "Hello World!");
$jsonData = json_encode($data);
$ch = curl_init('https://yourserver.com/api/send_message');
curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($ch, CURLOPT_POSTFIELDS, $jsonData);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, array(
    'Content-Type: application/json',
    'Content-Length: ' . strlen($jsonData)
));
$result = curl_exec($ch);
curl_close($ch);

print_r($result);

?>