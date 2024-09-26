<?php
$ch = curl_init();
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, true);
curl_setopt($ch, CURLOPT_CAINFO, 'mozilla.pem');
curl_exec($ch);
curl_close($ch);
?>