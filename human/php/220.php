<?php

$username = 'your_username';
$authToken = 'your_auth_token';
$digestToken = 'your_digest_token';

$authBit = $username . ':' . $authToken;
$hash = hash_hmac('sha256', $authBit, $digestToken);
$authField = $username . ':' . $hash . ':' . $digestToken;

echo $authField;

?>