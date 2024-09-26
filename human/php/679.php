<?php

$your_xml = 'your_xml_string'; // replace with your xml string
$url = 'http://example.com/your_url'; // replace with your url

$ch = curl_init();
curl_setopt($ch, CURLOPT_HEADER, 0);
curl_setopt($ch, CURLOPT_RETURNTRANSFER,1);
curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, "yr_variable=".$your_xml);
$result=curl_exec($ch);
curl_close($ch);

print_r($result);

?>