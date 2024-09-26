
<?php

// Initialize cURL session
$ch = curl_init();

// Set the URL of the web service
curl_setopt($ch, CURLOPT_URL, 'https://yourdomain.com/appserver/j_spring_security_check');

// Set the POST method and the POST fields
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, 'j_username=admin&j_password=demoserver');

// Ignore SSL certificate verification
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);

// Include the header in the output and set the content type
curl_setopt($ch, CURLOPT_HEADER, true);
curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-type: application/x-www-form-urlencoded'));

// Save cookies in cookies.txt
curl_setopt($ch, CURLOPT_COOKIEJAR, 'cookies.txt');
curl_setopt($ch, CURLOPT_COOKIEFILE, 'cookies.txt');

// Execute the cURL session
$response = curl_exec($ch);

// Check for errors and display the error message
if (curl_errno($ch)) {
    $error_msg = curl_error($ch);
