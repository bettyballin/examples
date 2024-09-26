<?php

require 'vendor/autoload.php';

use Kreait\Firebase\Factory;
use Kreait\Firebase\Exception\InvalidArgumentException;
use Kreait\Firebase\Exception\InvalidToken;

$firebase = (new Factory())
    ->withServiceAccount('path/to/your-service-account.json')
    ->create();

// Get the token from your client
$idTokenString = $_POST['token'];

try {
    $verifiedIdToken = $firebase->getAuth()->verifyIdToken($idTokenString);

    // If verification is successful you can get user information
    $uid = $verifiedIdToken->claims()->get('sub');

} catch (InvalidArgumentException | InvalidToken $e) {

   echo 'The token could not be parsed: ' . $e->getMessage() . PHP_EOL;

}