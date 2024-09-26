<?php

$apiUrl = 'https://api.example.com/endpoint'; // replace with your API URL

try {
    $response = file_get_contents($apiUrl . '?' . http_build_query([
        // ... other parameters
        "password" => getenv("API_PASSWORD")
    ]));

    if ($response === false) {
        throw new Exception('Failed to fetch data from API');
    }

} catch (Exception $e) {
    error_log($e->getMessage());

    // Display a generic message or redirect the user
    echo "An unexpected error occurred. Please try again later.";

    exit();
}

?>