<?php
$url = "http://localhost/data.php";
$params = array(
  "SSN" => $theSSN
);

$ch = curl_init($url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($params));
$response = curl_exec($ch);
curl_close($ch);

// Do whatever you need here, once the data arrives.
?>