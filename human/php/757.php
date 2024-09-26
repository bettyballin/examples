<?php
$c = curl_init();
curl_setopt($c, CURLOPT_HTTPHEADER, array('X-Auth-Token: asdflkjasdflkjasdflkjsadflkjasdf'));
curl_setopt($c, CURLOPT_RETURNTRANSFER, true);
curl_setopt($c, CURLOPT_URL, 'http://example.com'); // replace with your URL
$response = curl_exec($c);
curl_close($c);
print_r($response);
?>