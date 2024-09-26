
<?php
// The URL of the login page
$loginUrl = 'https://example.com/login';

// Initialize cURL session
$ch = curl_init();

// Set cURL options to get the login page
curl_setopt($ch, CURLOPT_URL, $loginUrl);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_COOKIEJAR, 'cookie.txt'); // Use a file to save cookies
curl_setopt($ch, CURLOPT_COOKIEFILE, 'cookie.txt'); // Use a file to read cookies

// Execute the request to get the
