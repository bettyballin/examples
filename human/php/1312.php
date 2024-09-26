<?php

$idToken = $_POST['idToken'];

$projectId = 'YOUR_PROJECT_ID';
$firebaseUrl = 'https://securetoken.google.com/' . $projectId . '/verifyIdToken';

$ch = curl_init($firebaseUrl);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_POST, true);
curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query(['idToken' => $idToken]));

$response = curl_exec($ch);
curl_close($ch);

$responseData = json_decode($response, true);

if ($responseData['error']) {
    http_response_code(401);
    echo 'Invalid ID token';
    exit;
}

// ID token is valid
// ...

?>