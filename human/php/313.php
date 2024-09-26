<?php

const SECRET_KEY = "abc123";

function call_api_with_secret($url, $params) {
  // create the hash to sign the request
  $hash = md5(SECRET_KEY . $url . json_encode($params));

  // call the api with the added hash
  call_api($url . "&hash=" . $hash, $params);
}

function call_api($url, $params) {
  // implement your API call logic here
  // for example, using curl:
  $ch = curl_init($url);
  curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
  curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($params));
  $response = curl_exec($ch);
  curl_close($ch);
  return $response;
}

// test the function
$url = "https://example.com/api/endpoint";
$params = array("param1" => "value1", "param2" => "value2");
$response = call_api_with_secret($url, $params);
print($response);

?>