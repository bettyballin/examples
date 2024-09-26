<?php

$filename = "https://api.com/person/1234/document/1234/data?key=1234&hash=1234";

// Initialize a cURL session
$ch = curl_init();

// Set the URL and other options
curl_setopt($ch, CURLOPT_URL, $filename);

// Return data instead of outputting it directly
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

// Execute cURL session
$contents = curl_exec($ch);

// Close the cURL session
curl_close($ch);

print($contents);

?>