Here is the executable PHP code:


<?php

$consumer = '';
$secret = '';
$callback = '';
$sign_method = 'HMAC-SHA1';
$version = '1.0';
$scope = 'https://www.googleapis.com/auth/latitude';

function urlencodeRFC3986($string)
{
   return str_replace('%7E', '~', rawurlencode($string));
}

$mt = microtime();
$rand = mt_rand();
$nonce = md5($mt.$rand);
$time = time();

$url = 'https://www.google.com/accounts/OAuthGetRequestToken';
$path = '/accounts/OAuthGetRequestToken';

$post = array(
    'oauth_callback' => urlencodeRFC3986($callback),
    'oauth_consumer_key' => $consumer,
    'oauth_nonce' => $nonce,
    'oauth_signature_method' => $sign_method,
    'oauth_timestamp' => $time,
    'oauth_version' => $version,
    'scope' => urlencodeRFC3986($scope)
);

$post_string = '';
foreach($post as $key => $value)
{
    $post_string .= $key.'='.($value).'&';
}
$post_string = rtrim($post_string, '&');

$key_parts = array($secret);

$key_parts = urlencodeRFC3986($secret);
$key = $key_parts.'&';
$base_string = 'GET&'.urlencodeRFC3986($url).'&'.urlencodeRFC3986($post_string);
$signature = base64_encode(hash_hmac('sha1', $base_string, $key, true));

$post = array(
    'oauth_version' => $version,
    'oauth_nonce' => $nonce,
    'oauth_timestamp' => $time,
    'oauth_consumer_key' => $consumer,
    'oauth_callback' => $callback,
    'oauth_signature_method' => $sign_method,
    'oauth_signature' => $signature
);        

$header_string = '';
foreach($post as $key => $value)
{
    $header_string .= $key.'="'.urlencodeRFC3986($value).'", ';
}

$header_string = trim($header_string);
$header_string = rtrim($header_string, ',');

$header[] = 'GET '.$path.'?scope='.urlencodeRFC3986($scope).' HTTP/1.1';
$header[] = 'Host: www.google.com';
$header[] = 'Accept: */*';
$header[] = 'Authorization: OAuth '.$header_string;

$ch = curl_init();
curl_setopt($ch, CURLOPT_HTTPHEADER, $header);
curl_setopt($ch, CURLOPT_URL, $url.'?scope='.$scope);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_FOLLOWLOCATION, true);
$result = curl_exec($ch);
curl_close($ch);
print_r($result);
die();

?>