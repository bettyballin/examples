
<?php

// The URL you want to proxy through to
$testUrl = "http://example.com";

// Proxy server details
$proxy = "your.proxy.server:port";
$proxyAuth = "user:password"; // if required

// cURL initialization
$ch = curl_init();

// Set cURL options
curl_setopt($ch, CURLOPT_URL, $testUrl);
curl_setopt($ch, CURLOPT_PROXY, $proxy);

// If your proxy requires authentication
curl_setopt($ch,
