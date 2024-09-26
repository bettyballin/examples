<?php
$postArr = $_POST;
$postArr['private_key'] = 'private-key';

$ch = curl_init("http://another-server/posturl"); 

curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1); 
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($postArr)); 
curl_exec($ch);
curl_close($ch);
?>