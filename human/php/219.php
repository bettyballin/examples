<?php
$ch = curl_init();
$params = json_encode(array('param1' => 'value', 'param2' => 'value'));
curl_setopt ($ch, CURLOPT_URL, 'http://site.com/restServer.php?action=foo&params=' . urlencode($params));
curl_setopt ($ch, CURLOPT_RETURNTRANSFER, 1);
$output = curl_exec($ch);
curl_close($ch);

$data = json_decode($output, true);

print_r($data);
?>