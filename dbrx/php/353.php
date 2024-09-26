<?php

use Firebase\Auth\Token\Exception\InvalidToken;
use Kreait\Firebase\Factory;

require 'vendor/autoload.php';

$factory = (new Factory)->withServiceAccount('/path/to/firebase_credentials.json');
$auth = $factory->createAuth();

try {
    $idTokenStringFromTheClient = 'your_id_token_string_here'; // replace with your id token string
    $verifiedIdToken = $auth->verifyIdToken($idTokenStringFromTheClient);
    $uid = $verifiedIdToken->getClaim('sub');
    echo 'The token is valid and the user\'s ID is: ' . $uid;
} catch (InvalidToken | InvalidArgumentException $e) {
    echo 'The token is invalid: ' . $e->getMessage();
}