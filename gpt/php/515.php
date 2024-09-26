
<?php
// proxy.php

// The URL of the distant server endpoint
$distant_server_url = 'https://distantserver.com/endpoint';

// Collect POST data from the form
$post_data = $_POST;

// Add your private key to the POST data
$post_data['private_key'] = 'your_private_key_here';

// Initialize cURL session
$ch = curl_init($distant_server_url);

// Set cURL options
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
