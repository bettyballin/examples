<?php
$api_url = 'https://api.example.com/data'; // replace with your API URL

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $api_url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);

$response = curl_exec($ch);
$http_code = curl_getinfo($ch, CURLINFO_HTTP_CODE);

if ($http_code != 200) {
    // Log the error and return a generic message to the user
    error_log("API request failed with code {$http_code}: " . $api_url);
    echo 'An error occurred while processing your request. Please try again later.';
} else {
    // Process the successful response
    $data = json_decode($response, true);

    if (json_last_error() !== JSON_ERROR_NONE) {
        // Log and handle invalid JSON responses
        error_log("Invalid JSON response from API: " . json_last_error_msg());
        echo 'An error occurred while processing your request. Please try again later.';
    } else {
        // Process valid data here
        print_r($data);
    }
}

curl_close($ch);