<?php
// Retrieve private key from secure storage
function get_private_key() {
    // Replace with your actual private key retrieval logic
    return 'your_private_key_here';
}

$privateKey = get_private_key();

// Validate and sanitize user input
$userInput = filter_var($_POST['userInput'], FILTER_SANITIZE_STRING);

// Add private key to user input
$modifiedPostData = array_merge(array('userInput' => $userInput), array('privateKey' => $privateKey));

// Forward request to distant server
$ch = curl_init('https://distant-server.com/api');
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($modifiedPostData));
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
$response = curl_exec($ch);
curl_close($ch);