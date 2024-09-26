<?php

require __DIR__ . '/vendor/autoload.php';

use Firebase\Auth\Token\Exception\InvalidToken;
use Google_Client;

$client = new Google_Client();
$client->setAuthConfig('path/to/client_secret.json');

$idTokenStringFromTheClient = 'id_token_string_from_the_client';

try {
    $payload = $client->verifyIdToken($idTokenStringFromTheClient);
} catch (InvalidToken $e) {
    echo 'The token is invalid: ' . $e->getMessage();
    exit;
}

if ($payload) {
    // The token is valid and the user's ID can be retrieved from it.
    echo 'The token is valid';
} else {
    echo 'The token is invalid';
}